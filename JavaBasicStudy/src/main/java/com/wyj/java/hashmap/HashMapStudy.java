package com.wyj.java.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapStudy {
    public static void main(String[] args) {

        hashFunctionStudy();
//        sameIndex_capacity_16();
//        index_capacity_32();
    }

    /**
     *  将数组的容量扩大为32后，之前具有相同索引的键值对的索引不同了，提高了查询效率。
     *
     */
    private static void index_capacity_32() {
        HashMap<String, String> map = new HashMap<>();
        map.put("chenmo", "沉默");
        map.put("wanger", "王二");
        map.put("chenqingyang", "陈清扬");
        map.put("xiaozhuanling", "小转铃");
        map.put("fangxiaowan", "方小婉");
        map.put("yexin", "叶辛");
        map.put("liuting","刘婷");
        map.put("yaoxiaojuan","姚小娟");

        // 遍历 HashMap
        for (String key : map.keySet()) {
            int h, n = 32;
            int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            int i = (n - 1) & hash;
            // 打印 key 的 hash 值 和 索引 i
            System.out.println(key + "的hash值 : " + hash +" 的索引 : " + i);
        }
    }

    /**
     *  出现了相同索引的键值对。
     *  需要采用拉链法将相同索引的键值对放到同一个桶的链表上，查询这样的元素时候就不能直接通过
     *  索引来查找了（时间复杂度为O（1）），需要遍历这个索引桶维护的链表来查询（时间复杂度为O(n)）。
     */
    private static void sameIndex_capacity_16() {
        HashMap<String, String> map = new HashMap<>();
        map.put("chenmo", "沉默");
        map.put("wanger", "王二");
        map.put("chenqingyang", "陈清扬");
        map.put("xiaozhuanling", "小转铃");
        map.put("fangxiaowan", "方小婉");
        map.put("yexin", "叶辛");
        map.put("liuting","刘婷");
        map.put("yaoxiaojuan","姚小娟");
        ArrayList<String> list = new ArrayList<>();
        list.add("1");

        // 遍历 HashMap
        for (String key : map.keySet()) {
            int h, n = 16;
            int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            int i = (n - 1) & hash;
            // 打印 key 的 hash 值 和 索引 i
            System.out.println(key + "的hash值 : " + hash +" 的索引 : " + i);
        }
    }

    /**
     *  HashMap中的hash方法，以及数组长度与hash值的取模运算，确定索引。
     */
    private static void hashFunctionStudy() {
        HashMap<String, String> map = new HashMap<>();
        map.put("chenmo", "沉默");
        map.put("wanger", "王二");
        map.put("chenqingyang", "陈清扬");
        map.put("xiaozhuanling", "小转铃");
        map.put("fangxiaowan", "方小婉");

        for (String key: map.keySet()) {
            int h, n = 16;
            int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            int i = (n - 1) & hash;
            System.out.println(key + "的hash值 : " + hash +" 的索引 : " + i);
        }
    }
}
