package thread.threadlocalTest;

public class Tools {
    private static ThreadLocal<String> t = new ThreadLocal<>();

    public static void set(String str){
        t.set(str);
    }

    public static String get(){
        return t.get();
    }
}
