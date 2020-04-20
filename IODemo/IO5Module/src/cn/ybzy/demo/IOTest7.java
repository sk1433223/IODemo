package cn.ybzy.demo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class IOTest7 {
    public static void main(String[] args) {
        Path path = Paths.get("e:\\bbb.txt");
        if(!Files.exists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
        writeBuffer.put("AsynchronousFileChannelTest".getBytes());
        writeBuffer.flip();

//        try {
//            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
//            Future<Integer> future = channel.write(writeBuffer, 0);
//            while (!future.isDone());
//            System.out.println("写入数据完成");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
            channel.write(writeBuffer, 0, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    System.out.println("写入数据完成，写入了多少个数据呢：" + result);
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
