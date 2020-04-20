package cn.ybzy.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class IOTest3 {
    public static void main(String[] args) {
        //首先我定义一个字符串，str，这个就是我要写入通道的内容
        String str = "asdfjsladfjsla5f5ds6F45sadF45asDf45SAfdSA5d4fs5a4dfAS4d5Fsad";
        //获取文件通道
        FileChannel fc = null;
        try {
            FileOutputStream fout = new FileOutputStream("d:\\bb.txt");
            fc = fout.getChannel();

            //创建缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            //把数据先放入缓冲区里
            byte[] data = str.getBytes();
            //System.out.println(Arrays.toString(data));
            for(int i=0;i<data.length;i++){
                buffer.put(data[i]);  //put方法，就是往缓冲区里放数据的方法
            }

            //最后，核心步骤，把缓冲区里的数据，写入文件通道
            buffer.flip(); //暂时，你就这样理解：把缓冲区从写入模式，变为读出模式
            while(buffer.hasRemaining()){
                System.out.println(fc.position());
                fc.write(buffer);
                System.out.println(fc.position());
                System.out.println(fc.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                FileChannel fc1 = fc.truncate(30);
            } catch (IOException e) {
                e.printStackTrace();
            }


            if(fc!=null){
                try {
                    fc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
