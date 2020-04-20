package cn.ybzy.demo;

import java.io.File;
import java.io.IOException;

/**
 * @author sk143
 * @Name：阿康
 * @Description：File相关属性
 * @Date：2020/2/12 16:02
 */
public class IOTest3 {
    public static void main(String[] args) {

        getFileDemo();
        //文件过滤器的使用demo
        File file = new File("D:\\aaa\\bbb\\ccc\\ddd");
        getJavaFiles(file);

    }

    /**
     * File相关的属性应用
     */
    public static void getFileDemo () {
        File file = new File("D:\\aaaa\\demo1.txt");
        //与名字有关的方法
        System.out.println("返回File标识的文件或目录:"+file.getName());
        System.out.println("将File转化为路径名字符串(String)类型:"+file.getPath());
        System.out.println("返回绝对路径:"+file.getAbsolutePath());
        System.out.println("返回File最后一级目录的父目录:"+file.getParent());
        // file.renameTo(new File("D:\\workspace")); // 重命名对应的项目目录,返回boolean值

        // 与文件检查有关的方法
        System.out.println("文件或目录是否存在:"+file.exists());
        System.out.println("是否为目录:"+file.isDirectory());
        System.out.println("是否为文件:"+file.isFile());
        System.out.println("是否可写:"+file.canWrite());
        System.out.println("是否可读:"+file.canRead());
        System.out.println("判断File对象是不是绝对路径:"+file.isAbsolute());

        // 与文件常规信息有关的方法
        System.out.println("文件最后修改时间:"+file.lastModified());
        System.out.println("文件长度:"+file.length());

        // 创建删除文件
        File file1 = new File("D:\\aaa\\bbb\\ccc\\ddd");
        try {
            boolean newFile = file1.createNewFile();
            System.out.println("创建(文件):"+newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 删除文件(文件夹)
        boolean delete = file1.delete();
        System.out.println("删除:"+delete);

        // 创建多级文件夹
        boolean mkdirs = file1.mkdirs();
        System.out.println("创建:"+mkdirs);

        // 遍历(文件夹)目录
        // 注:目标目录不存在抛出NullPointerException异常
        File file3 = new File("D:\\aaa\\bbb\\ccc\\ddd");
        String[] fileNames = file3.list();
        File[] files = file3.listFiles();

        // 目录下文件和文件夹
        assert fileNames != null;
        for(String filename:fileNames) {
            System.out.println(filename);
        }

        assert files != null;
        for(File subFile:files){
            // 文件的绝对路径
            System.out.println(subFile);
        }
    }

    /**
     * 过滤器拦截File文件
     * @param file 文件
     */
    public static void getJavaFiles(File file){
        //判断传过来的file对象是不是文件夹
        if(!file.isDirectory()){
            return;
        }

        //是文件夹才是进一步扫描的基础
        File[] files = file.listFiles(subFile -> {
            //在这个方法里写过滤规则
            //1子目录要，2.java文件是我要的
            if(subFile.isDirectory()){
                return true;
            }else{
                return subFile.getName().toLowerCase().endsWith(".java");
            }
        });

        // 过滤后的结果文件我要给看看
        assert files != null;
        for(File rsFile:files){
            if(rsFile.isDirectory()){
                // 使用递归来进入更深层的文件夹
                getJavaFiles(rsFile);
            }else {
                System.out.println(rsFile);
            }
        }
    }
}
