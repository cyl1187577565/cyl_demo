package jvm.classLoaderDemo;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/18
 */
public class HelloWorld {
    static{
        System.out.println(">> Hello world Class is Initialized.");
    }

    public String welcome() {
        return "hello world";
    }
}
