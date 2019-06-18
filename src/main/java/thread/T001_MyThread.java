package thread;

public class T001_MyThread implements Runnable {
    private Integer i;

    public T001_MyThread(Integer i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++){
            new Thread(new T001_MyThread(i)).start();
        }
        System.out.println(Thread.currentThread().getName());

    }
}
