package com.wyj.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo03 {
    private static final AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                handleCount(true);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                handleCount(false);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("count:" + count.get());
    }

    private static void handleCount(boolean isPlus) {
        if (isPlus) {
            count.incrementAndGet();
        } else {
            count.decrementAndGet();
        }
    }
}
