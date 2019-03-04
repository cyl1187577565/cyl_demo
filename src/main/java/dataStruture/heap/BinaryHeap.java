package dataStruture.heap;

public class BinaryHeap<T extends Comparable<?>> {

    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private T[] array;

    public  BinaryHeap(){};
    public  BinaryHeap(int capacity){};
    public BinaryHeap(T[] array){};

    public void insert(T t){};
    public T findMin(){return null;}
    public T deleteMin(){return null;}
    public boolean isEmpty(){return Boolean.TRUE;}

}
