package com.zhukejiaowo.simple.httpcore;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.impl.nio.DefaultHttpClientIODispatch;
import org.apache.http.impl.nio.pool.BasicNIOConnPool;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.nio.protocol.BasicAsyncRequestProducer;
import org.apache.http.nio.protocol.BasicAsyncResponseConsumer;
import org.apache.http.nio.protocol.HttpAsyncRequestExecutor;
import org.apache.http.nio.protocol.HttpAsyncRequester;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.nio.reactor.IOEventDispatch;
import org.apache.http.protocol.*;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Description:
 *
 * @author caishang9
 * @version 1.0.0
 *
 * Minimal pipelining HTTP/1.1 client.
 */
/*
 * =========================== 维护日志 ===========================
 * 2018/1/3  caishang9 新建代码
 * =========================== 维护日志 ===========================
 */
public class PipeliningHttpClient {


    public static void main(final String[] args) throws Exception {
        // Create HTTP protocol processing chain
        final HttpProcessor httpproc = HttpProcessorBuilder.create()
                // Use standard client-side protocol interceptors
                .add(new RequestContent())
                .add(new RequestTargetHost())
                .add(new RequestConnControl())
                .add(new RequestUserAgent("Test/1.1"))
                .add(new RequestExpectContinue(true)).build();
        // Create client-side HTTP protocol handler
        final HttpAsyncRequestExecutor protocolHandler = new HttpAsyncRequestExecutor();
        // Create client-side I/O event dispatch
        final IOEventDispatch ioEventDispatch = new DefaultHttpClientIODispatch(protocolHandler,
                ConnectionConfig.DEFAULT);
        // Create client-side I/O reactor
        final ConnectingIOReactor ioReactor = new DefaultConnectingIOReactor();
        /* Create HTTP connection pool */
        final BasicNIOConnPool pool = new BasicNIOConnPool(ioReactor, ConnectionConfig.DEFAULT);
        // Limit total number of connections to just two
        pool.setDefaultMaxPerRoute(2);
        pool.setMaxTotal(2);
        // Run the I/O reactor in a separate thread
        final Thread t = new Thread(new Runnable() {

            public void run() {
                try {
                    // Ready to go!
                    ioReactor.execute(ioEventDispatch);
                } catch (final InterruptedIOException ex) {
                    System.err.println("Interrupted");
                } catch (final IOException e) {
                    System.err.println("I/O error: " + e.getMessage());
                }
                System.out.println("Shutdown");
            }

        });
        // Start the client thread
        t.start();
        // Create HTTP requester
        final HttpAsyncRequester requester = new HttpAsyncRequester(httpproc);

        final HttpHost target = new HttpHost("www.apache.org");
        final List<BasicAsyncRequestProducer> requestProducers = Arrays.asList(
                new BasicAsyncRequestProducer(target, new BasicHttpRequest("GET", "/index.html")),
                new BasicAsyncRequestProducer(target, new BasicHttpRequest("GET", "/foundation/index.html")),
                new BasicAsyncRequestProducer(target, new BasicHttpRequest("GET", "/foundation/how-it-works.html"))
        );
        final List<BasicAsyncResponseConsumer> responseConsumers = Arrays.asList(
                new BasicAsyncResponseConsumer(),
                new BasicAsyncResponseConsumer(),
                new BasicAsyncResponseConsumer()
        );

        final CountDownLatch latch = new CountDownLatch(1);

        final HttpCoreContext context = HttpCoreContext.create();
        requester.executePipelined(
                target, requestProducers, responseConsumers, pool, context,
                new FutureCallback<List<HttpResponse>>() {

                    @Override
                    public void completed(final List<HttpResponse> result) {
                        latch.countDown();
                        for (final HttpResponse response: result) {
                            System.out.println(target + "->" + response.getStatusLine());
                        }
                    }

                    @Override
                    public void failed(final Exception ex) {
                        latch.countDown();
                        System.out.println(target + "->" + ex);
                    }

                    @Override
                    public void cancelled() {
                        latch.countDown();
                        System.out.println(target + " cancelled");
                    }

                });

        latch.await();
        System.out.println("Shutting down I/O reactor");
        ioReactor.shutdown();
        System.out.println("Done");
    }
}
