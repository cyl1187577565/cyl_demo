package thread.useMutipleCondition;

import java.util.concurrent.TimeUnit;

public class Client {

    public static void main(String[] args) throws InterruptedException {

        MyService service = new MyService();

        ThreadA tA = new ThreadA(service);
        tA.setName("A");
        ThreadB tB = new ThreadB(service);
        tB.setName("B");

        tA.start();
        tB.start();
        TimeUnit.MILLISECONDS.sleep(5000);

        service.signalA();


    }
}
