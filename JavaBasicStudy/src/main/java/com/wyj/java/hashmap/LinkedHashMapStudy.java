package com.wyj.java.hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapStudy {

    public static void main(String[] args) {
//        getInsertOrderElementTest();
        getInsertNotOrderElementTest();
        Map<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("沉", "沉默王二");
        linkedHashMap.put("默", "沉默王二");
        linkedHashMap.put("王", "沉默王二");
        linkedHashMap.put("二", "沉默王二");

        System.out.println(linkedHashMap);

        linkedHashMap.get("默");
        System.out.println(linkedHashMap);

        linkedHashMap.get("王");
        System.out.println(linkedHashMap);
    }

    /**
     *  HashMap 遍历元素是无序的。
     */
    private static void getInsertNotOrderElementTest() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("沉", "沉默王二");
        hashMap.put("默", "沉默王二");
        hashMap.put("王", "沉默王二");
        hashMap.put("二", "沉默王二");
        hashMap.put(null, null);

        for (String key : hashMap.keySet()) {
            System.out.println(key + " : " + hashMap.get(key));
        }
    }

    /**
     *  LinkedHashMap 可以维持元素的插入顺序。
     */
    private static void getInsertOrderElementTest() {
        // 创建 LinkedHashMap 对象，键类型为 String，值类型为 String
        Map<String, String> map = new LinkedHashMap<>();

        // 使用 put() 方法向 LinkedHashMap 中添加数据
        map.put("chenmo", "沉默");
        map.put("wanger", "王二");
        map.put("chenqingyang", "陈清扬");

        // 遍历 LinkedHashMap，输出所有键值对
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}
