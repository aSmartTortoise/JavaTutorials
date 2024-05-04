package com.wyj.thread;

import java.util.concurrent.*;

public class ThreadDemo06 {
    public static void main(String[] args) {
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000L);
                int result = 1000;
                System.out.println("call method execute...");
                return result;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        new Thread(futureTask).start();
        try {
            System.out.println("futureTask get method execute.");
            Integer result = futureTask.get();
            System.out.println("result:" + result);
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(futureTask);
            Integer result1 = futureTask.get();
            System.out.println("result1:" + result1);
//            Executors.newFixedThreadPool(5).execute(new Runnable() {
//                @Override
//                public void run() {
//
//                }
//            });
            FutureTask<?> future = (FutureTask<?>) Executors.newSingleThreadExecutor().submit(futureTask);
            Object result2 = future.get();
            System.out.println("result2:" + result2);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
