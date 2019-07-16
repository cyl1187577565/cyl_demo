package thread.waitNotify;

public class Test1 {
    public static void main(String[] args) {
        String ll = new String("");
        try {
            ll.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
