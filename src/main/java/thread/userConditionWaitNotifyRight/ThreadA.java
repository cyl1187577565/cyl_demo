package thread.userConditionWaitNotifyRight;

import java.util.concurrent.TimeUnit;

public class ThreadA extends Thread {
    private MyService service;

    public ThreadA(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }

    public static void main(String[] args) {
        try {
            MyService service = new MyService();
            ThreadA a = new ThreadA(service);
            a.start();
            TimeUnit.MILLISECONDS.sleep(1000);
            service.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
