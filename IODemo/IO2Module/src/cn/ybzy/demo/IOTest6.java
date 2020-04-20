package cn.ybzy.demo;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.io.StringWriter;

public class IOTest6 {
    public static void main (String[] args) throws IOException {
        String s = "study 5 hard and 6 make 11 progess every day";
        StringReader sr = new StringReader(s);

//        //从流中把数据取出来
//        StringWriter sw = new StringWriter();
//        char[] c = new char[1024];
//        int hasRead = 0;
//        while((hasRead=sr.read(c))!=-1){
//            //讲从输入流里读出来的数据，在放到输出流里
//            sw.write(c,0,hasRead);
//        }
//
//        System.out.println(sw.toString());

        StreamTokenizer st = new StreamTokenizer(sr);
        //记录字符串里的数字的个数
        int numCount = 0;
        //记录字符串里的单词个数
        int wordCount = 0;
        while (st.nextToken()!=StreamTokenizer.TT_EOF){ //读取到的标记不是流的末尾标记
            //st.nextToken()被调用后，st.ttype就会有刚刚从流里读取的标记的类型
            int flagType = st.ttype;
            if(flagType == StreamTokenizer.TT_NUMBER){
                System.out.println(st.nval); //拿出这个数字
                numCount++;
            }else if(flagType == StreamTokenizer.TT_WORD){
                System.out.println(st.sval);
                wordCount++;
            }
        }
        System.out.println("整个字符串里的数字个数：" + numCount);
        System.out.println("整个字符串里的单词个数：" + wordCount);

    }
}
