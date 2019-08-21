//package thread.threadlocalTest;
//
//import java.time.LocalDateTime;
//import java.util.concurrent.TimeUnit;
//
//public class ThreadA extends Thread {
//
//    @Override
//    public void run() {
//        try {
//            for (int i = 0; i < 20; i++){
//                 if(Tools.get() == null || Tools.get().length() <= 0){
//                     Tools.set("ThreadA" + LocalDateTime.now().toString());
//                 }
//                System.out.println("A "+Tools.get());
//                TimeUnit.MILLISECONDS.sleep(10);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
