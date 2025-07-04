package com.wyj.java.thread;

/**
 * Created
 * Author: wyj
 *
 * 为一个不安全的资源添加了一个互斥锁，确保同一时间只有一个线程可以使用这个资源，从而确保线程安全。
 */
public class Resource {
    private Mutex mutex = new Mutex();

    public void use() {
        mutex.lock();
        try {
            // 对资源的操作
        } finally {
            mutex.unlock();
        }
    }
}
