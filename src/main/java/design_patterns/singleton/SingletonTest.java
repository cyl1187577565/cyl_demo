package design_patterns.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton3 singleton1 = Singleton3.getOne();
        Singleton3 singleton11 = Singleton3.getOne();

        System.out.println(singleton1.equals(singleton11));
    }
}
