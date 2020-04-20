package cn.ybzy.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class IOTest15 {
    public static void main(String[] args) {
        //玩儿重定向标准输出
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream("d:\\eeee.txt");
            ps = new PrintStream(fos);

            //关键就是它，干了事情：改了不System.out它管理的物流设备
            System.setOut(ps);

            //改变了关联关系后，在运行System.out.println()；
            System.out.println("关联了关联关系，这里的内容会进入文件了，不会显示在屏幕下面的控制台了！");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null) ps.close();
        }


    }
}
