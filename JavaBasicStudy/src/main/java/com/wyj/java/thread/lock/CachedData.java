package com.wyj.java.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachedData {
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private Object data;
    private boolean cacheValid;

    public void processCachedData() {
        // Acquire read lock
        rwl.readLock().lock();
        if (!cacheValid) {
            // Must release read lock before acquiring write lock
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            try {
                // Recheck state because another thread might have
                // acquired write lock and changed state before we did
                if (!cacheValid) {
                    data = fetchDataFromDatabase();
                    cacheValid = true;
                }
                // Downgrade by acquiring read lock before releasing write lock
                rwl.readLock().lock();
            } finally {
                rwl.writeLock().unlock(); // Unlock write, still hold read
            }
        }

        try {
            use(data);
        } finally {
            rwl.readLock().unlock();
        }
    }

    private Object fetchDataFromDatabase() {
        // Simulate fetching data from a database
        return new Object();
    }

    private void use(Object data) {
        // Simulate using the data
        System.out.println("使用数据: " + data);
    }

    public static void main(String[] args) {
        CachedData cachedData = new CachedData();
        cachedData.processCachedData();
    }
}
