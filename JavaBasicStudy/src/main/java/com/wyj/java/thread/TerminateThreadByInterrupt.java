package com.wyj.java.thread;

public class TerminateThreadByInterrupt extends Thread{
    @Override
    public void run() {
        super.run();
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("thread is running...");
            long time = System.currentTimeMillis();
            while (System.currentTimeMillis() - time < 1000L) {

            }
        }
        System.out.println("thread exit");
    }
}
