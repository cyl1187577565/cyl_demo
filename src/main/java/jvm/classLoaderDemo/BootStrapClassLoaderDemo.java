package jvm.classLoaderDemo;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/18
 */
public class BootStrapClassLoaderDemo {
    public static void main(String[] args) {
        System.out.println("Bootstrap: " + String.class.getClassLoader());
        //rootClassLoader 的加载类路径
        System.out.println(System.getProperty("sun.boot.class.path"));
        //extClassLoader 加载的路径
        System.out.println(System.getProperty("java.ext.dirs"));
        //ApplicationClassLoader 的加载路径
        System.out.println(System.getProperty("java.class.path"));
    }
}
