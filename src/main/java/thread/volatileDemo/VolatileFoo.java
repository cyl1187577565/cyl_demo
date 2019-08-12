package thread.volatileDemo;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/18
 */
public class VolatileFoo {
    final static  int maxValue = 5;
    volatile static int initValue = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = initValue;
            while (localValue < maxValue){
//                System.out.println(">> initValue : " + initValue);
                if(initValue != localValue){
                    System.out.println(">> The initValue has changed to " + initValue);
                    localValue = initValue;
                }
            }
        },"reader").start();

        new Thread(() -> {
            int localValue = initValue;

            while (localValue < maxValue){
                System.out.println(">> The initValue will changed to : " + ++localValue);
                initValue = localValue;

                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "updater").start();

    }
}
