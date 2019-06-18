package io.nio;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class TimeClientHandle implements Runnable{



    private String host;
    private int port;
    private Selector selector;
    private SocketChannel sc;
    private volatile boolean stop;

    public TimeClientHandle(String host, int port) {
        this.host = "127.0.0.1";
        this.port = port;

        try {
            selector = Selector.open();
            sc = SocketChannel.open();
            sc.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {

    }

    private void doConnect() throws Exception{
//        byte[] req =
    }
}
