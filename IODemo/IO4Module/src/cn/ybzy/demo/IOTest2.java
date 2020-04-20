package cn.ybzy.demo;



import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class IOTest2 {
    public static void main(String[] args) {
        //实验NIO的用法
        //学习的是FileChannel，使用它，首先我们要获取到FileChannel对象实例
        //先实现读操作
        FileChannel fc = null;
        try {
            RandomAccessFile raf = new RandomAccessFile("d:\\aa.txt","rw");
            //进一步的通过raf对象，获取FileChannel实例
            fc = raf.getChannel();

            //要处理数据，NIO的处理数据的基本模式，必须要有缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(48); //创建的缓冲区大小是48字节
            //读取数据，就是把channel里数据写入缓冲区
            int hasRead = fc.read(buffer);


            //了解到了这个返回值
            while(hasRead!=-1){
                //先要用一下Buffer里的方法，先初略的了解一下作用，后面细讲
                buffer.flip(); //在这里理解为，把缓冲区从写入模式，改为读取模式
                while(buffer.hasRemaining()){
                    System.out.print((char)(buffer.get()));;
                }
                //把当前的缓冲区里的数据全部都拿出来了，就清空当前的缓冲区
                buffer.clear();
                hasRead = fc.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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

