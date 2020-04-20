package cn.ybzy.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class IOTest1 {
    public static void main(String[] args) {
        RandomAccessFile rf = null;
        RandomAccessFile rfr = null;
        try {
            Employee employee1 = new Employee("zhangsan",12);
            Employee employee2 = new Employee("lisi",15);
            Employee employee3 = new Employee("wnagmazi",20);
            rf = new RandomAccessFile("D:\\employee.txt","rw");
            rf.write(employee1.name.getBytes());
            rf.writeInt(employee1.age);

            rf.write(employee2.name.getBytes());
            rf.writeInt(employee2.age);

            rf.write(employee3.name.getBytes());
            rf.writeInt(employee3.age);

            //下面才是真正展示RandomAccessFile的技术
            rfr = new RandomAccessFile("D:\\employee.txt","r");
            System.out.println("先读第二个员工的信息");
            rfr.skipBytes(12);
            String str = "";
            for(int i=0;i<8;i++){
                str += (char)rfr.readByte();
            }
            System.out.println("员工2的名字：" + str);
            System.out.println("员工2的年龄:" + rfr.readInt());

            System.out.println("回头来读第一个员工");
            rfr.seek(0);
            String str1 = "";
            for(int i=0;i<8;i++){
                str1 += (char)rfr.readByte();
            }
            System.out.println("员工1的名字：" + str1);
            System.out.println("员工1的年龄:" + rfr.readInt());


            System.out.println("读第三个员工：");
            rfr.skipBytes(12);
            String str2 = "";
            for(int i=0;i<8;i++){
                str2 += (char)rfr.readByte();
            }
            System.out.println("员工3的名字：" + str2);
            System.out.println("员工3的年龄:" + rfr.readInt());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(rf!=null) {
                try {
                    rf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(rfr!=null){
                try {
                    rfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

class Employee{
    public String name;
    public int age;

    public Employee(String name,int age){
        //这个实验的约定：名字都起英文或者是拼音
        //搞点代码包装名字都是8字节
        if(name.length()>8){
            name = name.substring(0,8);
        }else {
            while(name.length()<8){
                name = name + "\u0000"; //"\u0000"这个是utf-8的编码表示空格
            }
            this.name = name;
            this.age = age;
        }
    }

}
