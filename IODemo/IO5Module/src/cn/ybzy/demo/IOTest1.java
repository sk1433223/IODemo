package cn.ybzy.demo;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.lang.reflect.Field;
import java.nio.channels.FileChannel;

public class IOTest1 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile fileFrom = new RandomAccessFile("e:\\aaa.txt","rw");
        FileChannel channelFrom = fileFrom.getChannel();

        RandomAccessFile fileTo = new RandomAccessFile("d:\\aaa.txt","rw");
        FileChannel channelTo = fileTo.getChannel();

        //channelTo.transferFrom(channelFrom,0,channelFrom.size());
        channelFrom.transferTo(0,channelFrom.size(),channelTo);
    }
}
