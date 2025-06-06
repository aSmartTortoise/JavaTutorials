package com.wyj.java.thread;

public class ThreadStudy {
    public static void main(String[] args) {
//        startThreadTest();
//        threadJoinTest();
//        setDaemonTest();
        Thread thread1 = new Thread(ThreadStudy::printNumbers, "刘备");
        Thread thread2 = new Thread(ThreadStudy::printNumbers, "关羽");

        thread1.start();
        thread2.start();
    }

    private static void setDaemonTest() {
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr, "张飞");
        Thread t2 = new Thread(mr, "貂蝉");
        Thread t3 = new Thread(mr, "吕布");
        t1.setDaemon(true);
        t2.setDaemon(true);
        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }

    private static void printNumbers() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);

            // 当 i 是偶数时，当前线程暂停执行
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " 让出控制权...");
                Thread.yield();
            }
        }
    }

    private static void threadJoinTest() {
        //创建MyRunnable类
        MyRunnable mr = new MyRunnable();

        Thread t1 = new Thread(mr, "张飞");
        Thread t2 = new Thread(mr, "貂蝉");
        Thread t3 = new Thread(mr, "吕布");

        t1.start();
        try {
            t1.join();//等待t1执行完才会轮到t2，t3抢
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        t3.start();
    }

    private static void startThreadTest() {
        //创建MyRunnable类
        MyRunnable mr = new MyRunnable();
        //创建Thread类的有参构造,并设置线程名
        Thread t1 = new Thread(mr, "张飞");
        Thread t2 = new Thread(mr, "貂蝉");
        Thread t3 = new Thread(mr, "吕布");
        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
