package cn.ybzy.demo;

import java.io.File;

/**
 * @author sk143
 * @Name：阿康
 * @Description：File文件的创建
 * @Date：2020/2/12 16:02
 */
public class IOTest2 {
    public static void main(String[] args) {
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);

        System.out.println(File.separator);
        System.out.println(File.separatorChar);

        // File file = new File("D:"+File.separator+"a.txt");
        File file = new File("ccc.txt");

        try {
            boolean newFile = file.createNewFile();
            if (newFile) {
                System.out.println("创建成功!");
            }
            // file.createNewFile(); // 创建文件
            // file.mkdir(); // 创建文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("创建的File路径::"+file.getAbsolutePath());
    }
}
