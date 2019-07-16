package thread.volatileTest;

public class Thread1 implements Runnable {
    private Object lock;

    public Thread1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for(int i = 0; i < 10 ; i++){
                if(i == 5){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("thread 1 processing:"+i);
            }
        }
    }
}
