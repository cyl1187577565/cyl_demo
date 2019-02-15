package jvm.io.bio;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 伪异步I/O
 */
public class CylServer2  {

    public static void main(String[] args) {
        startServer();
    }
    private static void startServer(){
        int port = 8080;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            if(server != null){
                System.out.println("The server is start in port : "+ port);
                Socket socket = null;
                ServerHandlerExecutorPool serverHandlerExecutorPool = new ServerHandlerExecutorPool(100, 100);
                while (true){
                    socket = server.accept();
                    CylServer.CylServerHandler cylServerHandler = new CylServer.CylServerHandler(socket);
                    serverHandlerExecutorPool.execute(cylServerHandler);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(server != null){
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ServerHandlerExecutorPool{

        private ExecutorService executorService;

        public ServerHandlerExecutorPool(int maxPoolSize, int queueSize){
            executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxPoolSize, 1200L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
        }
        public void execute(Runnable task){
            executorService.execute(task);
        }
    }
}
