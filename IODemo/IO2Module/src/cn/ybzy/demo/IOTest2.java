package cn.ybzy.demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author sk143
 */
public class IOTest2 {
    public static void main(String[] args) throws IOException {

        byteArrayInputStreamDemo();
        System.out.println("===========================");
        byteArrayOutputStreamDemo();

    }

    /**
     * 数组输入流
     * 1.把数组的数据封装成一个流
     * 2.对封装的流进行操作(读取)
     */
    public static void byteArrayInputStreamDemo() throws IOException {
        //验证我们，demo我们前面讲的理论，数据流
        //数组输入流
        //先定义一个数组
        byte[] b1 = new byte[]{1, 2, 3, 4};
        //可以b1数组，转换形式为 字节输入流
        ByteArrayInputStream bais = new ByteArrayInputStream(b1);
        //上面一句话就转换

        //显示输入流中的剩余的数组数量(数组长度)
        System.out.println(bais.available());

        //能放，也要能收
        byte[] b2 = new byte[2];
        // 把bais里的流输出到b2数组中
        bais.read(b2);
        System.out.println(Arrays.toString(b2));
        System.out.println("读取1次以后，输入流里剩下的数据量：" + bais.available());

        bais.read(b2);
        System.out.println(Arrays.toString(b2));
        System.out.println("读取2次以后，输入流里剩下的数据量：" + bais.available());

        bais.read(b2);
        System.out.println(Arrays.toString(b2));
        System.out.println("读取3次以后，输入流里剩下的数据量：" + bais.available());
    }

    /**
     * 数组输出流
     *
     * @throws IOException
     */
    public static void byteArrayOutputStreamDemo() throws IOException {
        // 把数组放到输出流中
        byte[] b1 = new byte[]{1, 2, 3, 4};
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(b1);
        // 在输出流取出
        byte[] b2 = baos.toByteArray();
        System.out.println(Arrays.toString(b2));

        // 会有乱码问题
        System.out.println(baos.toString());
        //把流输出到D:盘下
        FileOutputStream fos = new FileOutputStream("D:\\a.txt");
        baos.writeTo(fos);
    }
}
