package cn.ybzy.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOTest9 {
    public static void main(String[] args) {
        try(
                InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\a.txt"),"GBK");
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\b.txt"))
        ){
            char[] c = new char[1024];
            int hasRead = 0;
            while((hasRead=isr.read(c))!=-1){
               osw.write(c,0,hasRead);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
