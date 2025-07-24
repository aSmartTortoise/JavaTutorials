package com.wyj.java.thread;

/**
 *  volatile修饰的变量不能保证并发访问共享变量的安全。
 */
public class VolatileTest {
    public static volatile int race = 0;
    public static void toIncreate() {
        race++;
    }
    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        toIncreate();
                    }
                }
            });
            threads[i].start();
        }
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("race:" + race);
    }
}
