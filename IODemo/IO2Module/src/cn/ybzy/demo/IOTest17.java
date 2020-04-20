package cn.ybzy.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOTest17 {
    public static void main(String[] args) {
        //用runtime里的exec方法，调用平台上的javac命令
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec("javac");
            //从p里边，获取到错误信息
            InputStreamReader reader = new InputStreamReader(p.getErrorStream(),"GBK");
            //进一步在封装reader
            br = new BufferedReader(reader);
            String buff = null;
            while((buff=br.readLine())!=null){
                System.out.println(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
