package com.wyj.java.thread;

public class ThreadDemo01 {
    public static void main(String[] args) throws InterruptedException {
//        terminateThreadBySemaphoreFun();
//        terminateThreadByInterruptFun();
        terminateBlockedTheadByInterruptFun();
    }

    /**
     * 通过Thead#interrupt实例方法中断阻塞状态的线程。
     * @throws InterruptedException
     */
    private static void terminateBlockedTheadByInterruptFun() throws InterruptedException {
        TerminateBlockedThreadByInterrupt thread = new TerminateBlockedThreadByInterrupt();
        thread.start();
        Thread.sleep(3000L);
        System.out.println("ask thread to interrupt.");
        thread.interrupt();
        Thread.sleep(3000L);
        System.out.println("application exit.");
    }

    /**
     * 通过Thead#interrupt实例方法中断非阻塞状态的线程
     * @throws InterruptedException
     */
    private static void terminateThreadByInterruptFun() throws InterruptedException {
        TerminateThreadByInterrupt thread = new TerminateThreadByInterrupt();
        thread.start();
        Thread.sleep(3000L);
        System.out.println("ask thread to stop.");
        thread.interrupt();
        Thread.sleep(3000L);
        System.out.println("application exit.");
    }

    /**
     *  通过终止信号终止非阻塞状态线程
     * @throws InterruptedException
     */
    private static void terminateThreadBySemaphoreFun() throws InterruptedException {
        TerminateThreadBySemaphore semaphoreThread = new TerminateThreadBySemaphore();
        semaphoreThread.start();
        Thread.sleep(3000L);
        System.out.println("ask thread to stop...");
        semaphoreThread.stop = true;
        Thread.sleep(3000L);
        System.out.println("stop application...");
    }


}
