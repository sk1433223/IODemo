package cn.ybzy.demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author sk143
 */
public class IOTest3 {
    public static void main(String[] args) throws IOException {
        /*
         * 数组输出流是一个可扩容的byte数组,默认32个字节大小,最大容量是2G
         */
        //用自己的类，创建数组输出流
        MyByteArrayOutputStream out = new MyByteArrayOutputStream();
        final int df = 32;

        //默认情况下，里面存放数组的buf的长度
        // out.getBuf().length==>拿到数组长度
        // out.size()==>获取数组里元素长度
        System.out.println(out.getBuf().length);
        System.out.println(out.size());
        System.out.println("========");
        for(int i = 0;i < df;i++){
            out.write(1);
        }
        
        System.out.println(out.getBuf().length);
        System.out.println(out.size());
        System.out.println("========");

        out.write(1);
        System.out.println(out.getBuf().length);
        System.out.println(out.size());
        System.out.println("========");

        out.write(new byte[98]);
        System.out.println(out.getBuf().length);
        System.out.println(out.size());

        System.out.println(Integer.MAX_VALUE);
    }
}

class MyByteArrayOutputStream extends ByteArrayOutputStream{
    // 拿到父类的buf属性
    public byte[] getBuf(){
        return super.buf;
    }
}
