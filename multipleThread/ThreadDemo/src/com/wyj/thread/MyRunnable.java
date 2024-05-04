package com.wyj.thread;

import java.util.Date;

public class MyRunnable implements Runnable {
    private String command;
    public MyRunnable(String c) {
        this.command = c;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " end time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
