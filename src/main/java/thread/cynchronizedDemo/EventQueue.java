package thread.cynchronizedDemo;

import java.util.LinkedList;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/17
 */
public class EventQueue {
    private int max;
    static class Event{

    }

    private LinkedList<Event> eventQueue = new LinkedList<>();
//    private final static Object notFull = new Object();
//    private final static Object notEmpty = new Object();
    private final static int DEFAULT_MAX_SIZE = 10;

    public EventQueue() {
        this(DEFAULT_MAX_SIZE);
    }

    public EventQueue(int max) {
        this.max = max;
    }

    public void put(Event event){
        synchronized (eventQueue){
            if (eventQueue.size() >= max) {
                try {
                    System.out.println(">>  queue is fulll");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(">> the new event is submitted ");
            eventQueue.addLast(event);
            eventQueue.notify();
        }
    }

    public Event get(){
        synchronized (eventQueue){
            if(eventQueue.size() <= 0 ){
                try {
                    System.out.println();
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Event event = eventQueue.removeFirst();
            System.out.println(">> the event："+event+" is handled");
            eventQueue.notify();
            return event;
        }
    }
}
