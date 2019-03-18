package design_patterns.singleton;

/*
懒汉模式
 */
public class Singleton2 {
    private static Singleton2 singleton2 = new Singleton2();

    private Singleton2(){

    }
    public static Singleton2 getSingleton(){
        return  singleton2;
    }
}
