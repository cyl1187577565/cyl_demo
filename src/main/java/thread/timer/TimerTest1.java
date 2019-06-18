package thread.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest1 {
    private static Timer timer = new Timer();
    static public class MyTask extends TimerTask{
        @Override
        public void run() {
            System.out.println("运行了！时间为："+ LocalDateTime.now());
        }
    }

    public static void main(String[] args) {
        try {
            MyTask myTask = new MyTask();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = "2019-4-24 18:12:10";
            Date parse = format.parse(dateString);

            timer.schedule(myTask,parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
