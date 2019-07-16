package thread.conditionDemo;

public class Client {
    public static void main(String[] args) {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.start();

    }
}
