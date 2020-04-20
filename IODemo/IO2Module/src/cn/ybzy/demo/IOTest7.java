package cn.ybzy.demo;

import java.io.*;

public class IOTest7 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try{
            fis = new FileInputStream("D:\\a.txt");
            fos = new FileOutputStream("D:\\b.txt");
            //缓冲流，类推所有处理流，就是对节点流进行二次封装
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //用法上有区别没
            byte[] b = new byte[1024];
            int hasRead = 0;
            while((hasRead=bis.read(b))!=-1){
                //输入流读取出来多少数据，就写到输出流
                bos.write(b,0,hasRead);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
