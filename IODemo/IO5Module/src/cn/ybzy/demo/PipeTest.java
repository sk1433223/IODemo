package cn.ybzy.demo;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PipeTest {
    public static void main(String[] args) {
        try{
            Pipe pipe = Pipe.open();
            new Thread(new ThreadA(pipe)).start();
            new Thread(new ThreadB(pipe)).start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


class ThreadA implements Runnable{
    private Pipe pipe;
    public ThreadA(Pipe pipe){
        this.pipe = pipe;
    }

    @Override
    public void run() {
        try {
            //A线程放数据
            Pipe.SinkChannel sink = pipe.sink();
            String data = "sadfjsadlkfjsdalkjfsdakjfksad";
            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
            writeBuffer.put(data.getBytes());

            writeBuffer.flip();
            while(writeBuffer.hasRemaining()){
                sink.write(writeBuffer);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class ThreadB implements  Runnable{
    private Pipe pipe;
    public ThreadB(Pipe pipe){
        this.pipe = pipe;
    }
    @Override
    public void run() {
       try{
           //B线程获取数据
           Pipe.SourceChannel source = pipe.source();
           ByteBuffer readBuffer = ByteBuffer.allocate(1024);
           source.read(readBuffer);

           readBuffer.flip();
           System.out.println("B线程获取的数据：" + new String(readBuffer.array())) ;


       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
