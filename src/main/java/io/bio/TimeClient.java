package io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient {
    private static final String ORDER = "query_time";

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8080;

        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try{
            socket = new Socket(host, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println(ORDER);
            System.out.println("send order to server success");
            String response = in.readLine();
            System.out.println("now is :"+ response);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(out != null){
                out.close();
            }

            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {

                }
            }
        }
    }
}
