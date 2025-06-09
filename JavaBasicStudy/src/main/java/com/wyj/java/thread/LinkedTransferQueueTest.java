package com.wyj.java.thread;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

public class LinkedTransferQueueTest {

    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();

        // Consumer Thread
        new Thread(() -> {
            try {
                System.out.println("消费者正在等待获取元素...");
                String element = queue.take();
                System.out.println("消费者收到: " + element);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Let consumer thread start first
        TimeUnit.SECONDS.sleep(1);

        // Producer Thread
        System.out.println("生产者正在传输元素");
        queue.transfer("Hello, World!");

        System.out.println("生产者已转移元素");
    }
}
