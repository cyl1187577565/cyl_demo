//package thread.threadlocalTest;
//
//import java.time.LocalDateTime;
//import java.util.concurrent.TimeUnit;
//
//public class ThreadB extends Thread {
//
//    @Override
//    public void run() {
//        try {
//            for (int i = 0; i < 20; i++){
//                 if(Tools.get() == null || Tools.get().length() <= 0){
//                     Tools.set("ThreadB" + LocalDateTime.now().toString());
//                 }
//                System.out.println("B "+Tools.get());
//                TimeUnit.MILLISECONDS.sleep(1000);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
