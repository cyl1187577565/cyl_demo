package thread.volatileDemo;

import java.util.concurrent.TimeUnit;

public class PringString implements Runnable{
    private boolean isContinuePrint = true;

    public void prinString(){
        while (isContinuePrint){
            try {
                System.out.println("run method threadName:"+Thread.currentThread().getName());
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        prinString();
    }

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }
}
