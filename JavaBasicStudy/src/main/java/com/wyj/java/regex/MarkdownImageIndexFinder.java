package com.wyj.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkdownImageIndexFinder {

    public static void main(String[] args) {
        String markdownText = "### 图片\n" +
                "您可以通方式：\n" +
                "\n" +
                "![roKkNFbQyfd6C3WIRl4n-6380239567.png](https://qidian-qbot-1251316161.cos.ap-guangzhou.myqcloud.com/public/1814309144478351360/1817826503458291712/image/aeWKgfzYjoLMkrtgzzwR-1828705147009630208.png)\n" +
                "\n" +
                "1.  使用遥控钥匙：长按智能遥控钥匙的锁止/解锁按键，车窗玻璃将自动上升。";

        // 使用正则表达式匹配Markdown图片格式
        String regex = "!\\[[^\\]]*\\]\\([^\\)]+\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(markdownText);

        // 遍历所有匹配项
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String imageMarkdown = markdownText.substring(start, end);

            System.out.println("找到的Markdown图片子串：" + imageMarkdown);
            System.out.println("开始索引：" + start);
            System.out.println("结束索引：" + end);
            String content = markdownText.replace(imageMarkdown, "<img>");
            System.out.println("replace 之后:" + content);
        }
    }
}
