package com.wyj.java.thread;

public class ThreadStateStudy {
    public static void main(String[] args) throws InterruptedException {
//        testStartMethod();
//        blockTest();
        waitingTest();

    }

    private static void blockTest() {
        Thread a = new Thread(() -> {
            testMethod();
        }, "a");

        Thread b = new Thread(() -> {
            testMethod();
        }, "b");

        a.start();
        b.start();
        System.out.println(a.getName() + ":" + a.getState());
        System.out.println(b.getName() + ":" + b.getState());
    }

    private static void waitingTest() throws InterruptedException{
        Thread a = new Thread(() -> {
            testMethod();
        }, "a");

        Thread b = new Thread(() -> {
            testMethod();
        }, "b");

        a.start();
        a.join();
        b.start();
        System.out.println(a.getName() + ":" + a.getState());
        System.out.println(b.getName() + ":" + b.getState());
    }

    private static synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void testStartMethod() {
        Thread thread = new Thread(() -> {});
        thread.start();
        thread.start();
    }
}
