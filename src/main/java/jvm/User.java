package jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.Instant;

/**
 * @ClassName User
 * @Author dianXiao2
 * @Date 2018/12/18 16:23
 **/
public class User {

    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static {
        System.out.println("initialize User");
    }


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("jvm.User");
        Constructor<?> constructor = aClass.getConstructor();

        long startTime = Instant.now().toEpochMilli();
        for(int i = 0 ; i < 1000000; i++){
            Object o = aClass.newInstance();
        }
        long endTime = Instant.now().toEpochMilli();
        System.out.println(">> 执行时间:"+(endTime-startTime)+" ms");

        startTime = Instant.now().toEpochMilli();
        for(int i = 0 ; i < 1000000; i++){
            Object o = constructor.newInstance();
        }
        endTime = Instant.now().toEpochMilli();
        System.out.println(">> 执行时间2:"+(endTime-startTime)+" ms");


        startTime = Instant.now().toEpochMilli();
        for(int i = 0 ; i < 1000000; i++){
            Object o = aClass.newInstance();
        }
        endTime = Instant.now().toEpochMilli();
        System.out.println(">> 执行时间3:"+(endTime-startTime)+" ms");
    }
}
