package jvm.threadLocal;

public class SequenceNumber {
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static int getNextNum(){
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        SequenceNumber sn = new SequenceNumber();
        Thread t1 = new Thread(new TestClient());
        Thread t2 = new Thread(new TestClient());
        Thread t3 = new Thread(new TestClient());
        t1.start();
        t2.start();
        t3.start();
    }

    private static class TestClient implements Runnable{


        @Override
        public void run() {
            for(int i = 0; i< 3; i++){
                System.out.println("Thread:"+Thread.currentThread().getName()+" >> " +SequenceNumber.getNextNum());
            }
        }
    }
}
