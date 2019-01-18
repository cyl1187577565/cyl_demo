package jvm.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName TestTimer
 * @Author dianXiao2
 * @Date 2018/12/20 12:17
 **/
public class TestTimer {

    public static void main(String[] args) {
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hhhhhhhhhhh");
            }
        },10000L);
    }
}
