package thread.readWriteLockDemo;

public class Client {
    public static void main(String[] args) {
        Count count = new Count();

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                count.get();
            }).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                count.put();
            }).start();
        }
    }
}
