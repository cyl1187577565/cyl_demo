package thread.synchronizedMethodLockObject;

public class Client {
    public static void main(String[] args) {
        MyObject obj = new MyObject();
        ThreadA a = new ThreadA(obj);
        ThreadB b = new ThreadB(obj);
        a.setName("a");
        b.setName("b");
        a.start();
        b.start();
    }


}
