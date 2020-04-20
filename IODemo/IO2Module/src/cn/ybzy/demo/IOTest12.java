package cn.ybzy.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PushbackInputStream;

public class IOTest12 {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("D:\\aa.txt");
        //把上面的输出流封装为打印流
        PrintStream ps = new PrintStream(fos);
        int i = 10;
        String s = "打印流";
        float f = 15.5f;
        ps.printf("整数【%s】,哈哈哈(%s),嘿嘿'%s'",i,s,f);
        ps.close();

    }
}
