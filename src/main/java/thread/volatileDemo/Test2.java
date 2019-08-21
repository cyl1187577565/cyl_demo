package thread.volatileDemo;

public class Test2 {
    public static void main(String[] args) {
        try {
            String lock = new String();

            synchronized (lock){
                System.out.println("哈哈哈");
                lock.wait();
                System.out.println("来嘛，来嘛");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
