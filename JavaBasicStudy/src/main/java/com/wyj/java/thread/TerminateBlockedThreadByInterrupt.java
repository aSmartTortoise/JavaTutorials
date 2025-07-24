package com.wyj.java.thread;

public class TerminateBlockedThreadByInterrupt extends Thread{
    @Override
    public void run() {
        super.run();
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Thead is running ...");
            try {
                /**
                 *  当调用了Thread#interrupt的实例方法，设置了线程的中断状态，运行到使当前线程进入阻塞或等待状态的方法
                 *  时候，会抛出InterruptedException，结束线程的阻塞或等待状态，且清除线程的中断状态。
                 */
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                System.out.println("thread interrupted.");
                System.out.println("当前线程是否被中断:" + Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("thead terminated.");
    }
}
