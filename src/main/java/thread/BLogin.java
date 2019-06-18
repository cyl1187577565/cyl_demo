package thread;

public class BLogin implements Runnable {
    @Override
    public void run() {
        LoginServlet.doPost("b","bb");
    }
}
