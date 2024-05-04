package com.wyj.thread;

public class ThreadDemo02 {
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                try {
                    handleCount(true);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                try {
                    handleCount(false);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("count:" + count);
    }

    private static void handleCount(boolean isPlus) throws InterruptedException {
        synchronized (ThreadDemo02.class) {
            if (isPlus) {
                count++;
            } else {
                count--;
            }
        }
    }
}
