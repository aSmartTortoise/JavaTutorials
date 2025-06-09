package com.wyj.java.thread;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {

    public static void main(String[] args) {
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        // Producer Thread
        new Thread(() -> {
            String event = "SYNCHRONOUS_EVENT";
            try {
                System.out.println("生产者准备放入: " + event);
                queue.put(event);
                System.out.println("生产者放入完成");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Consumer Thread
        new Thread(() -> {
            try {
                Thread.sleep(200L);
                System.out.println("消费者准备取出数据...");
                String event = queue.take();
                System.out.println("消费者取出: " + event);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
