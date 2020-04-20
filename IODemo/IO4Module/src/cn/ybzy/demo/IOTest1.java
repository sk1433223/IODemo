package cn.ybzy.demo;

import java.io.*;

public class IOTest1 {
    public static void main(String[] args) {
        BufferedReader buffer = null;
        try {
            InputStream in  =  new FileInputStream("d:\\aa.txt");
            buffer = new BufferedReader(new InputStreamReader(in));
            String name = buffer.readLine();
            String age =  buffer.readLine();
            String email = buffer.readLine();
            String phone = buffer.readLine();

            System.out.println(name);
            System.out.println(age);
            System.out.println(email);
            System.out.println(phone);


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(buffer!=null){
                try {
                    buffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
