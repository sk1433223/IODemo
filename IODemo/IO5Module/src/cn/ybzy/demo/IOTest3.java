package cn.ybzy.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class IOTest3 {
    public static void main(String[] args) {
//        Path path = Paths.get(".","aaa.txt");
//        Path path1 = Paths.get("e:\\","aaa.txt");
//
//        System.out.println(path.toAbsolutePath());
//        System.out.println(path1.toAbsolutePath());

        //D:\workspace\workspaceidea\IODemo\.\aaa.txt
        //D:\workspace\workspaceidea\IODemo\aaa.txt

        //D:\workspace\workspaceidea\IODemo\..\aaa.txt
        //D:\workspace\workspaceidea\aaa.txt

//        System.out.println(Files.exists(path1,new LinkOption[]{LinkOption.NOFOLLOW_LINKS}));

//        Path path = Paths.get("e:\\bbb\\");
//        if(!Files.exists(path,new LinkOption[]{LinkOption.NOFOLLOW_LINKS})){
//            try {
//                Files.createDirectory(path);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


        Path spath = Paths.get("e:\\ccc.txt");
        Path spath1 = Paths.get("e:\\aaa.txt");
        Path dpath = Paths.get("e:\\bbb\\ccc.txt");

//        try {
//            Files.copy(spath,dpath, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            Files.move(spath,spath1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            Files.delete(spath1);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
