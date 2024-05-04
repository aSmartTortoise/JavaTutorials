package com.wyj.java.operation;

/**
 *  运算
 *
 *  取模、取余运算。
 *
 *
 */
public class OperationStudy {
    public static void main(String[] args) {
        int a = -7;
        int b = 3;

        int remainder = a % b;// 取余
        int modulus = Math.floorMod(a, b);//取模

        System.out.println("数字: a = " + a + ", b = " + b);
        System.out.println("取余 (%): " + remainder);
        System.out.println("取模 (Math.floorMod): " + modulus);

        a = 7;
        b = -3;

        remainder = a % b;
        modulus = Math.floorMod(a, b);
        int modulus2 = a & b;

        System.out.println("\n数字: a = " + a + ", b = " + b);
        System.out.println("取余 (%): " + remainder);
        System.out.println("取模 (Math.floorMod): " + modulus);
        System.out.println("取模 (&): " + modulus2);
    }
}
