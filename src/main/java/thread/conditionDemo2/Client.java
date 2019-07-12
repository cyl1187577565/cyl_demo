package thread.conditionDemo2;

public class Client {
    public static void main(String[] args) {
        MyService service = new MyService();

        Producer p = new Producer(service);
        Consumer c = new Consumer(service);

        p.start();
        c.start();
    }
}
