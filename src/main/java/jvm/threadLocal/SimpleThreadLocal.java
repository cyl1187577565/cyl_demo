package jvm.threadLocal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 一个简单的threadLocal
 */
public class SimpleThreadLocal {
    private Map valueMap = new ConcurrentHashMap();

    public void set(Object newValue){
        valueMap.put(Thread.currentThread(), newValue);
    }

    public Object get(){
        Thread currentThread = Thread.currentThread();
        Object o = valueMap.get(currentThread);

        if(o == null && !valueMap.containsKey(currentThread)){
            o = initialValue();
            valueMap.put(currentThread, o);
        }
        return o;
    }

    public void remove(){
        valueMap.remove(Thread.currentThread());
    }

    public Object initialValue(){
        return null;
    }
}
