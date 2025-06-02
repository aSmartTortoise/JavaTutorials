package com.wyj.java.hashmap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<T, Y> {
    private final Map<T, Y> cache = new LinkedHashMap<>(100, 0.75f, true);
    private final long maxSize;
    private long currentSize;

    public LruCache(long maxSize) {
        this.maxSize = maxSize;
    }

    protected long getSize(Y item) {
        return 1;
    }

    protected void onItemEvicted(T key, Y item) {
        
    }

    public synchronized Y get(T key) {
        return cache.get(key);
    }

    public synchronized Y put(T key, Y item) {
        long itemSize = getSize(item);
        if (itemSize >= maxSize) {
            onItemEvicted(key, item);
            return null;
        }
        currentSize += itemSize;
        Y old = cache.put(key, item);
        if (old != null) {
            currentSize -= getSize(old);

            if (!old.equals(item)) {
                onItemEvicted(key, old);
            }
        }
        trimToSize(maxSize);
        return old;
    }

    public synchronized void trimToSize(long size) {
        Iterator<Map.Entry<T, Y>> cachedIterator;
        Map.Entry<T, Y> last;
        while (currentSize > size) {
            cachedIterator = cache.entrySet().iterator();
            last = cachedIterator.next();
            Y item = last.getValue();
            T key = last.getKey();
            currentSize  -= getSize(item);
            cachedIterator.remove();
            onItemEvicted(key, item);
        }
    }
}
