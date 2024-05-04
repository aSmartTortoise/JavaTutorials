package com.wyj.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo05 {
    private static volatile int count = 0;
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
        System.out.println("count:" + count);
    }

    private static void handleCount(boolean isPlus) {
        if (isPlus) {
            count++;
        } else {
            count--;
        }
    }
}
