package thread.joinTest;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    @Override
    public void run() {
        try{
            int secodeValue = (int)Math.random()*10000;
            System.out.println(secodeValue);
            TimeUnit.MILLISECONDS.sleep(5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Task tk = new Task();
            Thread thread  = new Thread(tk);
            thread.start();
            thread.join(1000);
            System.out.println("我想当threa对象执行完毕后我在执行，我做到了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
