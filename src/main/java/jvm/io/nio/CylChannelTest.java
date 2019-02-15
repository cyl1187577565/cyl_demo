package jvm.io.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.RandomAccess;

/**
 * nio 的channel测试
 */
public class CylChannelTest {

    public static void main(String[] args) throws Exception{
        try {
            RandomAccessFile file = new RandomAccessFile("d:/test1.txt","rw");
            FileChannel channel = file.getChannel();
            //设置buffer的capacity
            ByteBuffer bf = ByteBuffer.allocate(1024);

            int read = channel.read(bf);
            while(read != -1){
                System.out.println("Read : " + read);
                //buffer从写模式切换成读模式
                bf.flip();
                byte[] bs = new byte[1024];
                while (bf.hasRemaining()){
                    byte b = bf.get();
                }
                // 清空buffer
                bf.clear();
                read = channel.read(bf);
                System.out.println("Read --:" + read);
            }
            //关闭file 不需要再次关闭channel，在关闭file的时候就已经关闭了channel
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}
