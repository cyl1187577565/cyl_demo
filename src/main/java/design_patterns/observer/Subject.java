package design_patterns.observer;

import jvm.io.bio.CylServer;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/6/20
 */
public interface Subject {

    enum CylStatus{
        INIT,RUNNING,DONE,ERROR;
    }

    CylStatus getStatus();

    // 定义启动线程的方法，主要作用是为了屏蔽Thread的方法
    void start();

    //定义中断线程的方法，作用与start方法一样， 主要用于屏蔽Thread的方法
    void interrupt();

    void add(Observer observer);

    void remove(Observer observer);

    void changed();
}
