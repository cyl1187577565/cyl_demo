package thread.volatileDemo;

public class Thread3 implements Runnable {
    private Object lock;

    public Thread3(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized(lock){
            for(int i = 0; i < 10; i++){
                if(i == 5){
                    System.out.println("现在的数字："+i);
                    try {
                        lock.wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread3 thread3 = new Thread3(new Object());
        Thread t = new Thread(thread3);

        t.start();
    }
}
