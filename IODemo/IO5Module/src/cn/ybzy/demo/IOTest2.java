package cn.ybzy.demo;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.SortedMap;

public class IOTest2 {
    public static void main(String[] args) throws CharacterCodingException {
//        SortedMap<String, Charset> map = Charset.availableCharsets();
//        for(String s : map.keySet()){
//            System.out.println(s);
//        }

        Charset charset = Charset.forName("GBK");
        CharsetEncoder encoder = charset.newEncoder();

        CharBuffer charBuffer = CharBuffer.allocate(20);
        charBuffer.put("中国人民万岁");
        charBuffer.flip();

        ByteBuffer byteBuffer = encoder.encode(charBuffer);

        for(int i=0;i<byteBuffer.limit();i++){
            System.out.println(byteBuffer.get(i) + "");
        }

        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());


        CharsetDecoder decoder = charset.newDecoder();
        CharBuffer charBuffer1 = decoder.decode(byteBuffer);

        for(int j=0;j<charBuffer1.limit();j++){
            System.out.print(charBuffer1.get(j));
        }


    }
}
