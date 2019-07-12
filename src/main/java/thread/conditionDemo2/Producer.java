package thread.conditionDemo2;

public class Producer extends Thread {
    private MyService service;

    public Producer(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        for(int i = 0; i < Integer.MAX_VALUE; i++){
            service.set();
        }

    }
}
