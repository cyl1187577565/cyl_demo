package jvm.io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CylServer {

    public static void main(String[] args) throws Exception{
        int port = 8080;
        ServerSocket server = null;
        server = new ServerSocket(port);
        System.out.println("the server is start in port : " + port);
        Socket socket = null;
        while (true){
            socket = server.accept();
            new Thread(new CylServerHandler(socket)).run();
        }
    }

    public static void resTime(Socket socket){
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(),true);

            String response = null;
            String body = null;
            while (true){
                body = reader.readLine();
                if (body == null){
                    break;
                }
                System.out.println("the server receive order : " + body);
                if("A".equals(body)){
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    response= simpleDateFormat.format(date);
                }else{
                    response = "bad order";
                }
                writer.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(writer != null){
                writer.close();
                writer = null;
            }

            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }

    static class CylServerHandler implements Runnable{
        private Socket socket;

        public CylServerHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            CylServer.resTime(socket);
        }
    }
}
