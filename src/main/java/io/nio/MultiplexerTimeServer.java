package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class MultiplexerTimeServer implements Runnable {
    private static final String ORDER = "query_time";

    private Selector selector;
    private ServerSocketChannel ssChannel;
    private volatile boolean stop;

    public MultiplexerTimeServer(int port) {
        try {
            selector = Selector.open();
            ssChannel = ServerSocketChannel.open();

            ssChannel.configureBlocking(false);
            ssChannel.socket().bind(new InetSocketAddress(port), 1024);
            ssChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("the time server is start in port:"+port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        stop = true;
    }

    @Override
    public void run() {
        while (!stop){
            try {
                int select = selector.select(1000);
                if(select == 0){
                    continue;
                }
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                SelectionKey key = null;
                while (iterator.hasNext()){
                    key = iterator.next();
                    iterator.remove();
                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        if( key != null){
                            key.cancel();
                            if(key.channel() != null){
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (selector !=null){
            try {
                selector.close();
            } catch (IOException e) {


            }
        }
    }

    private void handleInput (SelectionKey key)throws Exception{

        if(key.isValid()){
            //处理新接入的请求消息
            if(key.isAcceptable()){
                ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
                SocketChannel accept = ssChannel.accept();
                accept.configureBlocking(false);
                accept.register(selector, SelectionKey.OP_READ);
            }
            if(key.isReadable()){
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(buffer);

                if (readBytes > 0) {
                    buffer.flip();
                    byte[] bytes = new byte[buffer.remaining()];
                    buffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("the time server receive order : "+ body);
                    String currentTime = ORDER.equals(body)? new Date().toString():"bad order";

                    doWrite(sc,body);
                } else if (readBytes < 0) {
                    // 对端链路关闭
                    key.cancel();
                    sc.close();
                }else{
                    //读到0个字节，忽略
                }
            }
        }
    }

    private void doWrite(SocketChannel channel, String response) throws IOException {
        if (response != null && response.trim().length() > 0) {
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
    }

    public static void main(String[] args) {
        int port = 8080;
        MultiplexerTimeServer multiplexerTimeServer = new MultiplexerTimeServer(port);
        new Thread(multiplexerTimeServer).start();
    }

}
