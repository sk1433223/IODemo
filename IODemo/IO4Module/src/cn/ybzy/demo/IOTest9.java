package cn.ybzy.demo;

import java.io.Console;
import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class IOTest9 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        Selector selector = Selector.open();
        //在向selector注册通道之前，先把通道设置为非阻塞模式
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_ACCEPT);

        selector.select();


    }
}
