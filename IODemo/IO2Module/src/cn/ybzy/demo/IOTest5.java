package cn.ybzy.demo;

import java.io.StringWriter;

public class IOTest5 {
    public static void main(String[] args) {
        //测试字符串输出流
        String s = "GOOD GOOD STUDY DAY DAY UP";
        //把上面的字符串转变成流
        StringWriter sw = new StringWriter();
        sw.write(s);
        sw.append(" HELO JAVA");
        sw.append(" HELO STREAM");
        sw.flush();

        //前面是把字符串放入流，后面在流里的字符串拿出来
        StringBuffer sb = sw.getBuffer();
        String s1 = sw.toString();

        System.out.println(s1);
        System.out.println(sb.toString());
    }
}
