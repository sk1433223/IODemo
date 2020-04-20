package cn.ybzy.demo;

import java.io.*;

public class IOTest3 {
    public static void main(String[] args) {
//        ObjectOutputStream objout = null;
//        try {
//            OutputStream out = new FileOutputStream("d:\\man.save");
//            objout = new ObjectOutputStream(out);
//            Man man = new Man("zhanghao",55);
//            objout.writeObject(man);
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
//        }

        ObjectInputStream objis = null;
        try {
            InputStream is = new FileInputStream("d:\\man.save");
            objis = new ObjectInputStream(is);
            Man man = (Man) objis.readObject();
            System.out.println(man);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(objis!=null){
                try {
                    objis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

class Man implements Externalizable{
    private static final long serialVersionUID = -4535199472137629698L;
    public String name;
    public int age;
    //public String sex; //添加这个字段后，在反序列化过程中创建的对象，序列化号会改变
    public Man(){
        System.out.println("无参数构造起被调用了！");
    }

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        //要序列化的属性
        out.writeObject(name); //序列化的时候要序列化name属性，字段
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        //这里设置的属性，才会被反序列
        name = (String) in.readObject();
        age = in.readInt();
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
