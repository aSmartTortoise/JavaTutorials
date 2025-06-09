package com.wyj.java.thread;

public class Task implements Comparable<Task> {

    private int priority;
    private String name;

    public Task(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(other.priority, this.priority);
    }

    public String getName() {
        return name;
    }
}
