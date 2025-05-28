package com.wyj.java.regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MarkdownImageExtractor {
    public static void main(String[] args) {
        // 输入的 Markdown 格式字符串
        String path = "调节座椅.md";
        // 读取文件内容
        StringBuilder markdownContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                markdownContent.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("读取文件失败: " + e.getMessage());
            return;
        }

        // Markdown 文件内容
        String content = markdownContent.toString();

        // 正则表达式：匹配符合条件的子串
//        String regex = "[-+*]\\s+.*\\n\\s+!";
//        String regex = "[-+*]\\s+.*\\n\\s+!\\[";
        String regex = "[-+*]\\s+.*\\n\\s+!\\[[^\\]]+\\]\\([^\\)]+\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);

        // 查找并打印符合条件的子串和索引
        boolean found = false;
        while (matcher.find()) {
            found = true;
            String matchedSubstring = matcher.group();
            int startIndex = matcher.start();
            int endIndex = matcher.end();

            System.out.println("匹配的子串:\n" + matchedSubstring);
            System.out.println("起始索引: " + startIndex + "，结束索引: " + endIndex);
            System.out.println("无序列表项后的字符为:->" + content.charAt(endIndex) + "<-");
            System.out.println("-------------");
        }

        if (!found) {
            System.out.println("没有匹配到任何子串。");
        }

    }
}


