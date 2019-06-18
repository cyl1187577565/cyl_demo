package thread;

public class CLogin implements  Runnable{
    @Override
    public void run() {
        LoginServlet.doPost("c","cc");
    }
}
