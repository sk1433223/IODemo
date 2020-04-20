package cn.ybzy.demo;

import java.io.*;

public class IOTest8 {
    public static void main(String[] args) throws IOException {
//        FileReader fr = new FileReader("D:\\a.txt");
//        int readContent;
//        while((readContent=fr.read())!=-1){
//            //字符流，可以直接
//            System.out.println((char)readContent);
//        }

        FileInputStream fis = new FileInputStream("D:\\a.txt");
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        //不能直接读，因为读出来是乱码
//        byte[] b = new byte[1024];
//        int hasRead = 0;
//        while((hasRead=fis.read(b))!=-1){
//            baos.write(b,0,hasRead);
//        }
//        byte[] c = baos.toByteArray();
//        System.out.println(new String(c,0,c.length));


        //用转换流，把上面的字节流转换成字符流，同时制定编码方式
        InputStreamReader isr = new InputStreamReader(fis,"GBK");
        int read;
        while((read=isr.read())!=-1){
            System.out.println((char)read);
        }
    }
}
