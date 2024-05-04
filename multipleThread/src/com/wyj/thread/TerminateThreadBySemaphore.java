package com.wyj.thread;

public class TerminateThreadBySemaphore extends Thread{
    volatile boolean stop = false;
    @Override
    public void run() {
        super.run();
        while (!stop) {
            System.out.println("Thread is running...");
            long time = System.currentTimeMillis();
            while (System.currentTimeMillis() - time < 1000L) {

            }

        }
        System.out.println("thread exiting...");
    }
}
