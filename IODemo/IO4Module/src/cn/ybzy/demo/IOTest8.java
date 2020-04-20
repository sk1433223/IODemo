package cn.ybzy.demo;

import sun.misc.Cleaner;
import sun.nio.ch.DirectBuffer;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class IOTest8 {
    public static void main(String[] args) throws Exception {
        //ByteBuffer.allocateDirect(100*1024*1024); //创建100M的直接缓冲区
//        for(int i=0;i<20000;i++) {
//            ByteBuffer.allocate(1024*100);  //100K
//        }
//        File file = new File("e:\\aaa");
//        FileInputStream fin = new FileInputStream(file);
//        //通过fin，获取文件通道
//        FileChannel channel = fin.getChannel();
//        //创建缓冲区
//        ByteBuffer buffer = ByteBuffer.allocateDirect((int)file.length());
//
//        long start = System.currentTimeMillis();
//        while(channel.read(buffer)!=-1){
//            buffer.flip();
//            buffer.get();
//            buffer.clear();
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("程序执行的时间：" + (end-start));
//
//        MappedByteBuffer bu = channel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());

        File file = new File("e:\\ggg");
        File file1 = new File("e:\\aaa");
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        RandomAccessFile raf1 = new RandomAccessFile(file1,"rw");
        FileChannel channel = raf.getChannel();
        FileChannel channel1 = raf1.getChannel();
//        long fileLen = file.length();
//        long cur = 0;
//        //512M
//        long mapSize = 1L << 29;
//        MappedByteBuffer mb = null;

        long start = System.currentTimeMillis();
//        //创建映射字节直接缓冲区
        MappedByteBuffer mb = channel.map(FileChannel.MapMode.READ_ONLY,0,file.length());
        MappedByteBuffer mb1 = channel1.map(FileChannel.MapMode.READ_WRITE,0,file.length());
        System.out.println(mb.position() + "," + mb.limit());
        while(mb.hasRemaining()){
            mb1.put(mb.get());
        }

//         for(;cur < fileLen;cur+=mapSize){
//             if(fileLen-cur<mapSize){
//                mb = channel.map(FileChannel.MapMode.READ_ONLY,cur,fileLen-cur);
//             }else{
//                 mb = channel.map(FileChannel.MapMode.READ_ONLY,cur,mapSize);
//             }
//             System.out.println(mb.position() + "," + mb.limit());
//             while(mb.hasRemaining()){
//                 mb.get();
//             }
//
//         }

        long end = System.currentTimeMillis();
        System.out.println("读文件的时间：" + (end-start));

        channel.close();
        raf.close();
//        Cleaner cleaner = ((DirectBuffer) mb).cleaner();
//        if(cleaner!=null){
//            cleaner.clean();//断开链接
//        }
//
//        file.renameTo(new File("e:\\ggg"));

    }


}
