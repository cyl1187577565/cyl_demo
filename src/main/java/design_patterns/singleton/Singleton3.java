package design_patterns.singleton;

/**
 * 静态内部类 （安全的单例模式）
 */
public class Singleton3 {

    private Singleton3() {
    }
    static class Inner{
        private static  Singleton3 singleton3 = new Singleton3();
    }

    public static Singleton3 getOne(){
        return  Inner.singleton3;
    }
}
