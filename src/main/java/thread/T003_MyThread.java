package thread;

public class T003_MyThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().isAlive());
    }
}
