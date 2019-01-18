package design_patterns.proxy;

/**
 * @ClassName GoodPerson
 * @Author dianXiao2
 * @Date 2018/12/17 21:00
 **/
public class GoodPerson implements IPerson {

    static {
        System.out.println("initialize GoodPerson");
    }

    public String hello(String name) {
        System.out.println("hello "+name);
        return "hello "+name;
    }

    public void hello() {
        System.out.println("ha ha ha !!!!!!!!!!!!!!!!!!!!!!");
    }


}
