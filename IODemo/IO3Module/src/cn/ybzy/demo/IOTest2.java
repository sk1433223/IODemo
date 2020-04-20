package cn.ybzy.demo;

import java.io.*;

public class IOTest2 {
//    public static void main(String[] args) {
//        //需要文件输出流
//        ObjectOutputStream objout = null;
//        ObjectInputStream objin = null;
//        try {
//            OutputStream out = new FileOutputStream("d:\\sss.obj");
//            objout = new ObjectOutputStream(out);
//            Person person = new Person("zhangsan",12,"男");
//            objout.writeObject(person); //最关键就是这句话实现对象序列化
//
//            InputStream is = new FileInputStream("d:\\sss.obj");
//            objin = new ObjectInputStream(is);
//            Person person1 = (Person) objin.readObject();
//            System.out.println(person1);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            if(objout!=null){
//                try {
//                    objout.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(objin!=null){
//                try {
//                    objin.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

//    }
}

class Person implements Serializable {
    private String name;
    private int age;
    private String sex;
    private static Person person = null;

    private Person() {
        System.out.println("无参数构造起，被调用了！");
    }

    private Person(String name, int age, String sex) {
        System.out.println("有参数构造起，被调用了！");
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public static Person getInstance(String name, int age, String sex){
       if(person==null){
           person = new Person(name,age,sex);
       }
       return person;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Object readResolve(){
        return  person;
    }
}
