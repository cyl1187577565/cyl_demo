package thread.threadlocalTest;

public class Client {
    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        a.start();
        ThreadB b = new ThreadB();
        b.start();
    }
}
