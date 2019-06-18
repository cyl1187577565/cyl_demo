package thread.atomicIntegerTest;

public class Client {
    public static void main(String[] args) {
        AddCountThread addCountThread = new AddCountThread();

        for(int i = 0 ; i < 100; i++){
            new Thread(addCountThread).start();;
        }
    }
}
