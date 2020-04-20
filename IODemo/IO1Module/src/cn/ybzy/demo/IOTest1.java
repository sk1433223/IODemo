package cn.ybzy.demo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * @author sk143
 * @Name：阿康
 * @Description：File文件获取路径
 * @Date：2020/2/12 16:02
 */
public class IOTest1 {
    public static void main(String[] args) {
        IOTest1 it1 = new IOTest1();
        try {
            it1.getUrl();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getUrl() throws IOException {
        //1.使用类加载路径
        String path ;
        path = this.getClass().getResource("/").getPath();
        //实质上拿到的路径就是我们平时说的类路径
        System.out.println("1:" + path);
        //getResource("/")，取消斜线,拿到的路径是当前类所在路径
        path = this.getClass().getResource("").getPath();
        System.out.println("1.1:" + path);

        //2.利用File类获取项目路径
        File file = new File("");
        path = file.getCanonicalPath();
        System.out.println("2:" + path);
        path = file.getAbsolutePath();
        System.out.println("2.1:" + path);

        //3.实质上还是第一种方法
        URL path1 = this.getClass().getResource("");
        System.out.println("3:" + path1);

        //4.利用System类
        path = System.getProperty("user.dir");
        System.out.println("4:" + path);

        //5.利用线程
        path = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        System.out.println("5:" + path);

        //6.在web项目中，request
        //request.getSession().getServletContext().getRealPath("/"));
    }
}


