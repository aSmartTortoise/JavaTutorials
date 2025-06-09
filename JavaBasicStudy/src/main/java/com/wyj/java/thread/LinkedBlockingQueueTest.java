package com.wyj.java.thread;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueTest {

    private static LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>(10);

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    blockingQueue.put(i);
                    System.out.println("生产者生产数据：" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Integer data = blockingQueue.take();
                    System.out.println("消费者消费数据：" + data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
