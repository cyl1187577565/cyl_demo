package thread.blockingQueueDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/11
 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(15);
        queue.put(11);
    }


    /**
     * 模仿ArrayBlockingQueue
     */
    static class MyArrayBlockingQueue<E>{
        // 数组的存储结构
        final Object[] items;
        //锁才用的机制
        final ReentrantLock lock;

        private final Condition notEmpty;

        private final Condition notFull;

        private int inputIndex;

        private int count;

        /**
         * 构造方法
         * @param capacity
         * @param fair
         */
        public MyArrayBlockingQueue(int capacity, boolean fair) {
            if(capacity < 0){
                throw new IllegalArgumentException();
            }

            this.items = new Object[capacity];
            lock = new ReentrantLock(fair);
            notEmpty = lock.newCondition();
            notFull = lock.newCondition();
        }

        public void put(E x) throws InterruptedException {
            checkNotNull(x);
            ReentrantLock lock = this.lock;
            lock.lockInterruptibly();

            while (count == items.length){
                notFull.wait();
            }


        }

        private void enqueue(E x){
            Object[] items = this.items;
            items[inputIndex] = x;

//            if(++inputIndex == items.)
        }

        /**
         * 判断是否是非空
         * @param x
         */
        private void checkNotNull(E x){
            if (x == null){
                throw new NullPointerException();
            }
        }

    }
}
