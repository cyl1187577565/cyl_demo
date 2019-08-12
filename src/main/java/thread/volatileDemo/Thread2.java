package thread.volatileDemo;

public class Thread2 implements Runnable {
    private Object lock;

    public Thread2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            for(int i = 0; i < 10; i++){
                if(i == 5){
                    lock.notify();
                }
                System.out.println("thread 2 processing: "+i);
            }
        }
    }
}
