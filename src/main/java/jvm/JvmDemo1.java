package jvm;

public class JvmDemo1 {
    public static void main(String[] args){
        for(String arg : args){
            System.out.println(arg);
        }

        System.out.println("Xmx:"+Runtime.getRuntime().maxMemory()/1000/1000 + " m");
    }
}
