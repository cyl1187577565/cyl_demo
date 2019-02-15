package jvm.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) throws Exception{
        Car car = initByDefaultConstructor();
        car.introduce();
    }


    private static Car initByDefaultConstructor()throws Exception{
        //通过类加载器获取Car的Class对象
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?> clazz = classLoader.loadClass("jvm.reflection.Car");

        //获取class的默认构造器对象并通过它实例化Car
        Constructor<?> cons = clazz.getDeclaredConstructor(null);
        Car car = (Car) cons.newInstance();

        //通过反射方法设置属性
        Method setBrand = clazz.getDeclaredMethod("setBrand", String.class);
        setBrand.invoke(car, "bmw");
        Method setColor = clazz.getDeclaredMethod("setColor", String.class);
        setColor.invoke(car, "red");
        Method setMaxSpeed = clazz.getDeclaredMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 100);
        return car;
    }
}
