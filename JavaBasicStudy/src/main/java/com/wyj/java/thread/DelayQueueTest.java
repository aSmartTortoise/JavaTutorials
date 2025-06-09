package com.wyj.java.thread;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {

    public static void main(String[] args) {
        DelayQueue<DelayedElement> queue = new DelayQueue<>();

        // 将带有5秒延迟的元素放入队列
        queue.put(new DelayedElement(5000, "这是一个 5 秒延迟的元素"));

        try {
            System.out.println("取一个元素...");
            // take() 将阻塞，直到延迟到期
            DelayedElement element = queue.take();
            System.out.println(element.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class DelayedElement implements Delayed {
        private final long delayUntil;
        private final String message;

        public DelayedElement(long delayInMillis, String message) {
            this.delayUntil = System.currentTimeMillis() + delayInMillis;
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(delayUntil - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            return Long.compare(this.delayUntil, ((DelayedElement) other).delayUntil);
        }
    }
}
