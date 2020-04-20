package cn.ybzy.demo;

import java.io.*;

public class IOTest4 {
    public static void main(String[] args) {
        ObjectOutputStream objout = null;
        ObjectInputStream objin = null;
        try {
            OutputStream out = new FileOutputStream("d:\\pp.save");
            objout = new ObjectOutputStream(out);
            Person person1 = Person.getInstance("张三",55,"男");
            objout.writeObject(person1);
            System.out.println("person1：" + person1);

            InputStream in = new FileInputStream("d:\\pp.save");
            objin = new ObjectInputStream(in);
            Person person2 = (Person) objin.readObject();
            System.out.println("person2：" + person2);

            System.out.println("反序列化后的对象，是不是前面对象序列化 的那个呢：" +( person1==person2));

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
           if(objout!=null){
               try {
                   objout.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if(objin!=null){
               try {
                   objin.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }
    }
}
