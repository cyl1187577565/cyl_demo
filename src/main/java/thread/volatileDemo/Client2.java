package thread.volatileDemo;

import java.util.concurrent.TimeUnit;

public class Client2 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread t1 = new Thread(new Thread1(lock));
        t1.start();
        TimeUnit.MILLISECONDS.sleep(2000);
        Thread t2 = new Thread(new Thread2(lock));
        t2.start();
    }
}
