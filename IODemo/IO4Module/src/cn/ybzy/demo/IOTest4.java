package cn.ybzy.demo;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class IOTest4 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(9);
        System.out.println("容量：" + buffer.capacity());
        System.out.println("上界：" + buffer.limit());
        System.out.println("位置：" + buffer.position());
        String str = "123456";
        byte[] strbyte = str.getBytes();
        buffer.put(strbyte);
        System.out.println("=============存了6字节后===============");
        System.out.println("上界：" + buffer.limit());
        System.out.println("位置：" + buffer.position());
        System.out.println("=============执行flip后===============");
        buffer.flip();
        System.out.println("上界：" + buffer.limit());
        System.out.println("位置：" + buffer.position());
        System.out.println("============================");
        System.out.println(buffer.isReadOnly());

//        System.out.print((char)buffer.get());
//        System.out.print((char)buffer.get());
//        System.out.print((char)buffer.get());
//        System.out.print((char)buffer.get());
//        System.out.print((char)buffer.get());
//        System.out.print((char)buffer.get());

        char[] dataarr = new char[buffer.limit()];
        for(int i=0;buffer.remaining()>0;i++){
            dataarr[i] = (char)buffer.get();
        }

        System.out.println(Arrays.toString(dataarr));


//        System.out.println("============================");
//        buffer.position(5);
//        System.out.println("位置：" + buffer.position());
//        buffer.mark();//做一个记号，实质上是把5位置保存到mark属性
//        System.out.println("============================");
//        buffer.position(8);
//        System.out.println("位置：" + buffer.position());
//        System.out.println("============================");
//        buffer.reset();
//        System.out.println("位置：" + buffer.position());

    }
}
