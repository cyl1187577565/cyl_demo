package jvm.jvmArgs;

public class J001_SimpleArgs {
    public static void main(String[] args) {
        //打印最大可用堆内存 "-Xmx设置最大堆内存"
        System.out.println("-Xmx " + Runtime.getRuntime().maxMemory()/1000/1000+" M");
    }
}
