package cn.ybzy.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class IOTest4 {
    public static void main(String[] args) {
        Path rootPath = Paths.get("C:\\Users\\Administrator\\Pictures"); //家目录，aaaa.txt
        String desFile = File.separator + "aaaa.txt";
        try {
            Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String stringFile = file.toAbsolutePath().toString();
                    if(stringFile.endsWith(desFile)){
                        System.out.println("要找的文件的位置：" + file.toAbsolutePath());
                        return FileVisitResult.TERMINATE; //结束变了
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
