package com.wyj.java.thread;

import java.util.concurrent.*;

public class CallableStudy {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Callable<String> task = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello from " + Thread.currentThread().getName();
            }
        };
        // 提交任务到ExecutorService执行，并获取Future对象
        Future[] futures = new Future[10];
        for (int i = 0; i < 10; i++) {
            futures[i] = executorService.submit(task);
        }

        // 通过Future对象获取任务的结果
        for (int i = 0; i < 10; i++) {
            System.out.println(futures[i].get());
        }

        // 关闭ExecutorService，不再接受新的任务，等待所有已提交的任务完成
        executorService.shutdown();

    }
}
