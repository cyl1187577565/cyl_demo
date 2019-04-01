package jvm.jvmArgs;

import java.util.ArrayList;
import java.util.List;

public class J004_Dump_out_of_memory {

    public static void main(String[] args) {
        List<Byte[]> list = new ArrayList<>();
        for (int i = 0; i<25; i++){
            list.add(new Byte[1*1024*1024]);
        }
    }
}
