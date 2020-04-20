package cn.ybzy.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class IOTest16 {
    public static void main(String[] args) {
//        重定向标准输入流
//        就是改变System.in原来的关联物流设备，原来是关联键盘
        try {
            InputStream in = new FileInputStream("d:\\aaa.txt");
            //System.setIn(in);

            Scanner sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            while (sc.hasNext()){
                System.out.println(sc.next());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
