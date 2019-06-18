package thread.synchronizedMethodLockObject;

public class ThreadB extends Thread {

    private MyObject object;

    public ThreadB(MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}
