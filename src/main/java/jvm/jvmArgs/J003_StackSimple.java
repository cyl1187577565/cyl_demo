package jvm.jvmArgs;

/**
 * 栈溢出 stackOverFlow
 */
public class J003_StackSimple {
    private static int count = 0;

    public static void recursion(){
        count++;
        recursion();
    }

    public static void main(String[] args) {
        try {
            recursion();
        } catch (Throwable e) {
            System.out.println("deep of calling = "+count);
            e.printStackTrace();

        }
    }
}
