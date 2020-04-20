package cn.ybzy.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class IOTest6 {
    public static void main(String[] args) throws IOException {
        //先创建原始缓冲区
        ByteBuffer buffery = ByteBuffer.allocate(9);
        //根据原始缓冲区，创建视图缓冲区,只读
        buffery.put("12345678".getBytes());
        buffery.flip();
        buffery.position(4);

        System.out.println(buffery.position());
        System.out.println(buffery.limit());

        ByteBuffer buffer2 = buffery.slice();
        System.out.println(buffer2.capacity());

        char[] c = new char[9];

        for(int i=0;buffer2.hasRemaining();i++){
            c[i] = (char) buffer2.get();
        }

        System.out.println(Arrays.toString(c));




        //根据原始缓冲区，创建视图缓冲区
//        ByteBuffer buffers = buffery.duplicate();
//
//        buffery.put("123456".getBytes());
//        System.out.println(buffery.position() + "," + buffery.limit());
//        System.out.println(buffers.position() + "," + buffers.limit());
//
//        char[] c = new char[6];
//        for(int i=0;i<6;i++){
//            c[i] = (char)buffers.get();
//        }
//
//        System.out.println(Arrays.toString(c));



//        ByteBuffer buffers = buffery.asReadOnlyBuffer();
//
//        System.out.println(buffers.isReadOnly());
//        buffers.put("111".getBytes());

    }
}
