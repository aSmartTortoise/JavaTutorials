package com.wyj.java.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileStreamStudy {

    public static void main(String[] args) {

        // 通过IO流读取Animal文件的内容
        String path = "Java基础.md";
        File file = new File(path);
        System.out.println("absolute path:" + file.getAbsolutePath());
        String filePath = "D:\\jackie\\study\\Java\\github\\JavaTutorials\\JavaBasicStudy\\src" +
                "\\main\\java\\com\\wyj\\java\\io\\Animal.java";
        File file1 = new File(filePath);
        System.out.println("directoryFile exist:" + file1.exists());
        try (BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

    }
}
