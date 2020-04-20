package cn.ybzy.demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class IOTest4 {
    public static void main(String[] args) throws IOException {
        //用多线程，一定会使用线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(6, 12, 200, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));

        //先声明管道输出流
        PipedOutputStream pout = new PipedOutputStream();
        PipedInputStream pin = new PipedInputStream(pout); //构造方法中传入pout对象，这一对流链接起来

        Sender sender = new Sender(pout);
        Receiver receiver = new Receiver(pin);

        //放到线程池里去分配线程执行
        executor.execute(sender);
        executor.execute(receiver);

        executor.shutdown();

        try {
            executor.awaitTermination(1,TimeUnit.HOURS); //执行shutdown以后
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

//先写生产者线程类
class Sender implements Runnable {
    private PipedOutputStream pout;

    public Sender(PipedOutputStream pout) {
        this.pout = pout;
    }

    @Override
    public void run() {
        try {
            //先定义一个字符串
            String s = "生产者发送测试数据";
            byte[] b = s.getBytes();
            pout.write(b); //信息发送出去
            System.out.println("发送出去的信息：" + s);
            pout.close();  //这里close，对面is才read返回-1
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Receiver implements Runnable {
    private PipedInputStream pin;

    public Receiver(PipedInputStream pin) {
        this.pin = pin;
    }

    @Override
    public void run() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            byte[] b = new byte[1024];
            int hasRead = 0;
            while ((hasRead = pin.read(b)) != -1) {
                //处理数据
                baos.write(b, 0, hasRead);
            }
            byte[] rs = baos.toByteArray();
            String s = new String(rs, 0, rs.length);
            System.out.println("接收到的信息：" + s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
