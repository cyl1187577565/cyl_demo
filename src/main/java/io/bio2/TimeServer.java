package io.bio2;

import io.bio.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 伪异步客户端， 使用了线程池
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;

        ServerSocket server = null;
        try{
            server = new ServerSocket(port);
            System.out.println("The timer server is start in port : " +port);

            Socket socket = null;
            TimeServerHandlerExecutePool timeServerHandlerExecutePool = new TimeServerHandlerExecutePool(10, 10);

            while (true){
                socket = server.accept();
                timeServerHandlerExecutePool.execute(new TimeServerHandler(socket));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(server != null){
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            server = null;
        }
    }
}
