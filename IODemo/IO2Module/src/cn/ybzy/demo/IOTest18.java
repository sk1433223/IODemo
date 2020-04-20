package cn.ybzy.demo;

import java.io.*;
import java.util.Scanner;

public class IOTest18 {
    public static void main(String[] args) {
        //我们一会儿要实现的写信息到子进程的父进程, 很显然父进程启动的子进程  java ReceiveInfo
        //创建出一个子进程
        PrintStream ps = null;
        try {
            Process p = Runtime.getRuntime().exec("java ReceiveInfo");
            OutputStream out = p.getOutputStream();
            //进一步的包装out，打印流
            ps = new PrintStream(out);
            //这里就可以像p进程里发送信息
            ps.println("普通的字符串");
            ps.println(6515615);
            ps.println(new IOTest18());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null) ps.close();
        }
    }
}


class ReceiveInfo{
    public static void main(String[] args) {
        //一会儿把这个类放到子进程里去执行，可以接收一下，父进程传来的数据
        // 并且把接收到的数据，保存到一个文件里去 D:\\rr.txt
        PrintStream ps = null;
        try {
            OutputStream out = new FileOutputStream("d:\\rr.txt");
            ps = new PrintStream(out);
            Scanner scanner = new Scanner(System.in); //此时的标准输入流，不是指键盘，是指父进程
            scanner.useDelimiter("\n");
            while(scanner.hasNext()){
                ps.print(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null) ps.close();
        }
    }
}
