package jvm.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class CylSelectorTest {
    public static void main(String[] args) throws IOException {
        // 创建Selector
        Selector selector = Selector.open();
        //向Selector中注册通道 通过SelectableChannel() 方法来实现
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8080));

        SelectionKey register = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        int i = register.interestOps();
    }
}
