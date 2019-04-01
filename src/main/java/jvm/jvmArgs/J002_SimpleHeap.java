package jvm.jvmArgs;

/**
 * 展示java堆，方法区和java栈之间的关系
 */
public class J002_SimpleHeap {
    private int id;
    public J002_SimpleHeap(int id){
        this.id = id;
    }

    public void show(){
        System.out.println("My id is : " +id);
    }

    public static void main(String[] args) {
        J002_SimpleHeap s1 = new J002_SimpleHeap(1);
        J002_SimpleHeap s2 = new J002_SimpleHeap(2);
        s1.show();
        s2.show();
    }
}
