package cn.ybzy.demo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class IOTest6 {
    public static void main(String[] args) {
//        try {
//            Path path = Paths.get("e:\\aaa.txt");
//            //构造出异步文件通道
//            //准备一个读缓冲区
//            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
//            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
//            Future<Integer> future = channel.read(readBuffer, 0);
//            //因为是异步的操作方式，所以我们能不能直接就在下面，读取readBuffer数据
//            //在读取readBuffer数据之前，我们必须要保证，从通道中取数据，写入缓冲区的这个行为，做完了后
//            while(!future.isDone());
//            //循环完了，表示，从通道中取数据，写入缓冲区这个事儿做了完了
//            readBuffer.flip();
//            System.out.println("缓冲区里的数据：" + new String(readBuffer.array()));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try{
            Path path = Paths.get("e:\\aaa.txt");
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
            channel.read(readBuffer, 0, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    //执行到这个方法的时候，就表示从通道中取数据，写入缓冲区这个事儿做了完了
                    System.out.println("result:" + result);
                    attachment.flip();
                    System.out.println(new String(attachment.array()));
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {

                }
            });




        }catch (Exception e){
            e.printStackTrace();

        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
