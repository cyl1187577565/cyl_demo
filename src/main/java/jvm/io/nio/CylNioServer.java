package jvm.io.nio;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class CylNioServer {

    public static void main(String[] args) throws Exception{


    }

    public void startServer() throws Exception{
        // 1 打开ServerSocketChannel
        ServerSocketChannel server = ServerSocketChannel.open();

        //2 绑定监听的端口，设置为非阻塞模式
        server.socket().bind(new InetSocketAddress(InetAddress.getLocalHost(),8080));
        server.configureBlocking(false);

        //3 创建Reactor线程，创建多路复用器并启动线程
        Selector selector = Selector.open();
    }
}
