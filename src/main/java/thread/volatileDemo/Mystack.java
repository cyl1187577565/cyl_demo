package thread.volatileDemo;

import java.util.ArrayList;
import java.util.List;

public class Mystack {
    private List<Double> list = new ArrayList<>();

    synchronized public void push(){
        try {
            if(list.size() == 1){
                this.wait();
            }
            list.add(Math.random());
            this.notify();
            System.out.println("push=" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public double pop(){
        double result = 0;
        try {
            if(list.size() == 0){
                System.out.println("pop 操作中的："+Thread.currentThread().getName()+" 线程承wait装填");
                this.wait();
            }
            result = list.get(0);
            list.remove(0);
            this.notify();
            System.out.println("pop = "+list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

}
