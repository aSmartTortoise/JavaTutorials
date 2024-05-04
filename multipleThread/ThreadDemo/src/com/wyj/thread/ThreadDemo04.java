package com.wyj.thread;

import java.text.SimpleDateFormat;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadDemo04 {
    private ThreadLocal<SimpleDateFormat> threadLocalsdf = ThreadLocal.withInitial(
            () -> new SimpleDateFormat("yyyy-MM-dd"));
}
