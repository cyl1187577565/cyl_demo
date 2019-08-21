package thread.volatileDemo;

public class Client {
    public static void main(String[] args) {
//        PringString ps = new PringString();
//        Thread t = new Thread(ps);
//        t.start();
//        System.out.println("我要停止它！ stop thread="+Thread.currentThread().getName());
//
//        ps.setContinuePrint(false);
        MyThread[] myThreads = new MyThread[100];
        for(int i = 0; i < myThreads.length; i++){
            myThreads[i]= new MyThread();
        }
        for(int i = 0; i < myThreads.length; i++){
            myThreads[i].start();
        }
    }
}
