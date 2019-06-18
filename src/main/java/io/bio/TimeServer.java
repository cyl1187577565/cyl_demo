package io.bio;

import org.apache.log4j.net.SocketServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket serverSocket = null;

        try {

            serverSocket = new ServerSocket(port);
            System.out.println("timer server is start in port : "+ port);

            Socket socket = null;
            while (true){
                socket = serverSocket.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket != null){
                System.out.println("the timer server close");
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
