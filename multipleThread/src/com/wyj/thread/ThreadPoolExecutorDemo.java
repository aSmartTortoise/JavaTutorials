package com.wyj.thread;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE = 4;
    private static final int MAXIMUM_POOL_SIZE = 9;
    private static final int QUEUE_CAPACITY = 128;
    private static final int KEEP_ALIVE_TIME = 30;


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.NANOSECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            Runnable worker = new MyRunnable(""+ i);
            executor.execute(worker);
        }
        Future<String> future = executor.submit(new MyRunnable("hi"), "");
        System.out.println("hi:" + future.get());
        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        System.out.println("Finish all threads.");
    }
}
