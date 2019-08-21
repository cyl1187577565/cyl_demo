package thread;

public class threadDemo {
    public static void main(String[] args) {
       Thread t = new Thread(){
           @Override
           public void run() {
               System.out.println(">> 我是新的线程");
           }
       };
       System.out.println(t.getThreadGroup());
       t.start();
    }
}
