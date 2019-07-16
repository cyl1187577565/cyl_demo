package thread;

public class T004_ThreadStop implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i <  500000; i ++){

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new T004_ThreadStop());
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        Thread.currentThread().interrupt();
        boolean interrupted = Thread.interrupted();
        System.out.println(interrupted);
        System.out.println("是否停止："+t.isInterrupted());
        System.out.println("end!");
    }
}
