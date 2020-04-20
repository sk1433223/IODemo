package cn.ybzy.demo;

import java.io.*;
import java.util.jar.JarEntry;

public class IOTest10 {
    public static void main(String[] args) {
//        Person p = new Person(); //程序运行到这里的时候，创建了一个Person类的对象
//        p.name="张三";
//        p.age=18;
//        p.sex="男";
//        ObjectOutputStream oout = null;
//        try{
//            //对象序列化工具对象流，可以把Person对象，变成二进制的数据，保存到磁盘
//            FileOutputStream out = new FileOutputStream("D:\\tmp.temp");
//            //进一步封装为缓冲流
//            BufferedOutputStream bout = new BufferedOutputStream(out);
//            //有了缓冲流，在进一步封装对象流
//            oout = new ObjectOutputStream(bout);
//
//            //然后才可以将对象，方到对象输出流里来
//            oout.writeObject(p);
//        }catch (IOException e){
//            e.printStackTrace();
//        }finally {
//            if(oout!=null){
//                try {
//                    oout.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        ObjectInputStream ois = null;
        try{
            FileInputStream fis = new FileInputStream("D:\\tmp.temp");
            BufferedInputStream bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);
            Person p = (Person) ois.readObject();
            System.out.println(p.name + "," + p.sex + "," + p.age);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


class Person implements Serializable{
    public String name;
    public int age;
    public transient String sex;
}
