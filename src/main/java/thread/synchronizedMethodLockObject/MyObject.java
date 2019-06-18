package thread.synchronizedMethodLockObject;

import java.util.concurrent.TimeUnit;

public class MyObject {

    public synchronized void methodA(){
        try {
            System.out.println("begin methodA threadName = "+ Thread.currentThread().getName());
            TimeUnit.MILLISECONDS.sleep(5000);
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
