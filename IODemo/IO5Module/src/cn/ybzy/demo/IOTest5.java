package cn.ybzy.demo;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class IOTest5 {
    public static void main(String[] args) {
        Path path = Paths.get("e:\\aaa");
//        try {
//            Files.delete(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            Files.walkFileTree(path,new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("delete file: " + file.toString());
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    System.out.println("delete dir:" + dir);
                    Files.delete(dir);
                    return  FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
