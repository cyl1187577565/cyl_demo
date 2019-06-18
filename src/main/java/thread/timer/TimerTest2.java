package thread.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest2 {
    static public class MyTask extends TimerTask{
        @Override
        public void run() {
            System.out.println("运行了！ 时间为："+ new Date());
        }

        public static void main(String[] args) {
            try {
                MyTask task = new MyTask();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dataString = "2019-4-24 20:05:30";
                Timer timer = new Timer();
                Date date = format.parse(dataString);
                System.out.println("字符串时间："+ dataString);
                timer.schedule(task,date,4000);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
