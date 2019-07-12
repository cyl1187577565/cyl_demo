package design_patterns.observer;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/6/20
 */
public interface Subject {
    void add(Observer observer);

    void remove(Observer observer);

    void changed();
}
