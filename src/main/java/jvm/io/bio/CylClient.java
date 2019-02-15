package jvm.io.bio;

import java.io.*;
import java.net.Socket;

public class CylClient implements Runnable{
    public static void main(String[] args) {
       for(int i = 0; i < 100000; i++){
           new Thread(new CylClient()).run();
       }
    }

    private static void getTime(){
        int port = 8080;
        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            socket = new Socket("127.0.0.1", port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(),true);
            writer.println("A");
            System.out.println("Send order to server success");
            String response = reader.readLine();
            System.out.println("Now is : "+ response);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(writer != null ){
                writer.close();
            }

            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        getTime();
    }
}
