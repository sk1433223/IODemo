package cn.ybzy.demo;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;

public class IOTest13 {
    public static void main(String[] args) throws IOException {
        //文件流，输入流，字符流
        Reader reader = new FileReader("d:\\aa.txt");
        //想要支持推回功能，把文件流进一步封装为推回输入流
        PushbackReader pr = new PushbackReader(reader,1024);
        //从输入流中，读取数据
        char[] c = new char[5];
        int hasReadCount = 0;
        String sumString = "";
        while ((hasReadCount=pr.read(c))!=-1){
            //真正的从输入流里获取数据
            //本次循环获取的的数据,转换成字符串
            String curString = new String(c,0,hasReadCount);
            sumString = sumString + curString;

            //sumString获取来的所有字符，差有没有，我不想要的数据的标记aaa
            int aaaIndex = sumString.indexOf("aaa");
            if(aaaIndex>-1){
                //证明读到了aaa,那么我们就要把数据推回去
                pr.unread(sumString.toCharArray());
                //unread，把所有的内容都还回去了
                //重新把我要的内容读出来
                if(aaaIndex > 5){
                    c = new char[aaaIndex];
                }
                pr.read(c,0,c.length);
                //现在c里就是我们要的内容
                System.out.println("我们的要的内容：" + new String(c));
                //我要的内容都拿到了，后面都是我不要的内容，循环还有意义
                break;
            }else{
                //读到的东西输出
                System.out.println(new String(c));
            }
        }
    }
}
