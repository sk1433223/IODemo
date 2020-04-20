package cn.ybzy.demo;

import java.io.*;

/**
 * 字节流和字符流的简单输入输出使用
 * @author sk143
 */
public class IOTest1 {
    public static void main(String[] args) {

        fileDemo0();
        fileDemo1();
    }

    /**
     * 无关闭File写法
     */
    public static void fileDemo0() {
        // 做一个事儿：把在D盘里的a.txt文件的内容读出来
        // 把FileReader定义在try()里面可以不在finally写.close关闭
        try (FileReader fis = new FileReader("D:\\a.txt");
             FileWriter fos = new FileWriter("D:\\b.txt")
        ) {
            //先定义两个东西
            char[] b = new char[1024];
            //一个计数器：已经读取到的数据的字节数
            int hasRead;
            while ((hasRead = fis.read(b)) > 0) {
                //在项目中，根据应用需求对读出来的数据进行处理
                System.out.println(new String(b, 0, hasRead));
                //读到的数据写入b.txt文件里去，每次读到多少数，就写多少数据
                fos.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 有finally关闭写法
     */
    public static void fileDemo1() {
        FileReader fis = null;
        FileWriter fos = null;
        //做一个事儿：把在D盘里的a.txt文件的内容读出来
        try {
            fis = new FileReader("D:\\a.txt");
            fos = new FileWriter("D:\\b.txt");
            //先定义两个东西
            char[] b = new char[1024];
            //一个计数器：已经读取到的数据的字节数
            int hasRead;
            while ((hasRead = fis.read(b)) > 0) {
                // 在项目中，根据应用需求对读出来的数据进行处理
                System.out.println(new String(b, 0, hasRead));
                // 读到的数据写入b.txt文件里去，每次读到多少数，就写多少数据
                fos.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert fis != null;
                fis.close();
                assert fos != null;
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
