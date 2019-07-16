package thread;

public class LoginClient {
    public static void main(String[] args) {
        Thread a = new Thread(new ALogin(), "a");
        Thread b = new Thread(new BLogin(),"b");
        a.start();
        b.start();
    }
}
