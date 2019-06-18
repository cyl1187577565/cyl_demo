package thread;

public class ALogin implements Runnable {
    @Override
    public void run() {
        LoginServlet.doPost("a","aa");
    }
}
