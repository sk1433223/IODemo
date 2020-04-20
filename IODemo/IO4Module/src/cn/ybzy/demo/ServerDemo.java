package cn.ybzy.demo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ServerDemo {
    public static void main(String[] args) {
        try {
            //先把ServerSocketChannel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1",8000));
            serverSocketChannel.configureBlocking(false);

            //再拿选择器的实例对象
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            //准备缓冲区
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
            writeBuffer.put("this is server".getBytes());
            writeBuffer.flip();


            //实实在在的和客户端进行交互
            while (true){
                int nReady = selector.select(1000); //阻塞的时间上限1s
                if(nReady == 0) continue;
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                while(it.hasNext()){
                    SelectionKey key = it.next();
                    it.remove(); //手动移除
                    if(key.isAcceptable()){
                        //isAcceptable返回true表明ServerSocketChannel已经准备好了接入新的链接
                        SocketChannel channel = serverSocketChannel.accept();//接入新链接
                        channel.configureBlocking(false);
                        channel.register(selector,SelectionKey.OP_READ);
                    }else if(key.isReadable()){
                        SocketChannel channel =  (SocketChannel) key.channel();
                        readBuffer.clear();
                        channel.read(readBuffer);

                        readBuffer.flip();
                        System.out.println("服务器端收到的数据，直接打印：" + new String(readBuffer.array()));
                        key.interestOps(SelectionKey.OP_WRITE);
                    }else if(key.isWritable()){
                        SocketChannel channel =  (SocketChannel) key.channel();
                        writeBuffer.rewind();
                        channel.write(writeBuffer);
                        key.interestOps(SelectionKey.OP_READ);
                    }
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
