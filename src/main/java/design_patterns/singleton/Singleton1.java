package design_patterns.singleton;

/**
 * 单例模式 饿汉模式
 */
public class Singleton1 {
    private static Singleton1 singleton;

    private Singleton1() {
    }

    public static Singleton1 getSingleton(){
        if(singleton == null){
            singleton = new Singleton1();
        }
        return singleton;
    }
}
