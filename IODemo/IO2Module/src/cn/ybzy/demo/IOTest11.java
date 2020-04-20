package cn.ybzy.demo;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class IOTest11 {
    public static void main(String[] args) throws IOException {
        //定义一个数组
        byte[] b = new byte[]{1,2,3,4,5};
        //在把这个数组编程数组流
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        //在进行一次封装，缓冲流,封装的过程中，我要制定缓冲区的大小为2个字节
        BufferedInputStream bis = new BufferedInputStream(bais,2);

        //先把第一个字节读取出来
        System.out.println(bis.read());

        System.out.println(bis.markSupported());

        bis.skip(1);

        System.out.println(bis.read());


        //现在心中要明白，指针在2上打一个标记
        bis.mark(1);
        //按照文档来说，我在读取超过1个字节的数据，标记就会失效

//        System.out.println(bis.read());
//        System.out.println(bis.read());
//        System.out.println(bis.read());
//
//        //上面读取了2个字节的数据，按文档的说明，mark就应该失效，reset就应该报错
//        bis.reset();
//
//        //reset方法，没失效，没报错
//        //指正重置了，回到了2上
//        System.out.println(bis.read());

    }
}
