package cn.ybzy.demo;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class IOTest5 {
    public static void main(String[] args) {
        ByteBuffer buffer1 = ByteBuffer.allocate(9);
        ByteBuffer buffer2 = ByteBuffer.allocate(9);

        buffer1.put("114".getBytes());
        buffer2.put("123".getBytes());

        buffer1.flip();
        buffer2.flip();

        //System.out.println(buffer1.equals(buffer2));

        //System.out.println(buffer1.compareTo(buffer2));

        System.out.println(buffer1.position());
        System.out.println(buffer1.limit());

        byte[] arr = new byte[10];

        buffer1.get(arr,0,3);

        System.out.println(buffer1.position());
        System.out.println(buffer1.limit());

        System.out.println(Arrays.toString(arr));


    }
}
