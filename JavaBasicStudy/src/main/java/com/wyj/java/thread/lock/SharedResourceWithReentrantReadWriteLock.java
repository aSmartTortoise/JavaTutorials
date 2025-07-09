package com.wyj.java.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用ReentrantReadWriteLock读写锁实现对共享资源的读多写少的并发访问。会出现“写饥饿”现象。
 * https://javabetter.cn/thread/lock.html#%E9%94%81%E7%8E%8Bstampedlock
 */
public class SharedResourceWithReentrantReadWriteLock {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int data = 0;

    public void write(int value) {
        lock.writeLock().lock();
        try {
            data = value;
            System.out.println("写: " + Thread.currentThread().getName() + " data:" + data);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int read() {
        lock.readLock().lock();
        try {
            System.out.println("读: " + Thread.currentThread().getName() + " data:" + data);
            return data;
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        SharedResourceWithReentrantReadWriteLock sharedResource = new SharedResourceWithReentrantReadWriteLock();

        Thread writer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.write(i);
            }
        }, "writer");

        Thread reader1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                int value = sharedResource.read();
            }
        }, "reader1");

        Thread reader2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                int value = sharedResource.read();
            }
        }, "reader2");

        reader1.start();
        reader2.start();
        writer.start();

        try {
            reader1.join();
            reader2.join();
            writer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
