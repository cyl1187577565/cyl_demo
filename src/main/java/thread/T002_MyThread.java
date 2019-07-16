package thread;

public class T002_MyThread implements Runnable {
    private int count = 5;
    @Override
    public void run() {
        count--;
        System.out.println("由"+Thread.currentThread().getName()+"计算，count："+count);
    }

    public static void main(String[] args) {
        T002_MyThread t002_myThread = new T002_MyThread();
        Thread t1 = new Thread(t002_myThread,"a");
        Thread t2 = new Thread(t002_myThread,"b");
        Thread t3 = new Thread(t002_myThread,"c");
        Thread t4 = new Thread(t002_myThread,"d");
        Thread t5 = new Thread(t002_myThread,"e");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
