package cn.ybzy.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientDemo {
    public static void main(String[] args) {
        try {
            SocketChannel channel = SocketChannel.open();
            channel.connect(new InetSocketAddress("127.0.0.1",8000));

            //准备缓冲区
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
            writeBuffer.put("this is client".getBytes());
            writeBuffer.flip();

            while(true){
                //先向服务器端写入数据
                writeBuffer.rewind();
                channel.write(writeBuffer);


                //然后在读取服务器端的数据
                readBuffer.clear();
                channel.read(readBuffer);

                readBuffer.flip();
                System.out.println("客户端收到的数据：" + new String(readBuffer.array()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
