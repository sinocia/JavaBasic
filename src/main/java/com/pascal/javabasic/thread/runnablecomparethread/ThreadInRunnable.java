package com.pascal.javabasic.thread.runnablecomparethread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther Pascal
 * @date 2020/11/7 14:55
 */
public class ThreadInRunnable implements Runnable {

    private Thread thread;
    private AtomicBoolean isRunning=new AtomicBoolean(false);
    private AtomicBoolean isInterrupted=new AtomicBoolean(false);

    @Override
    public void run() {
        isRunning.set(true);
        System.out.println("currentThread: "+thread.getName()+" is running");

    }

    public  void start(){
        thread=new Thread(this);
        thread.start();
    }

    public static void main(String[] args) {
        ThreadInRunnable threadInRunnable=new ThreadInRunnable();
        System.out.println("currentThread: "+Thread.currentThread().getName()+" is running");
        threadInRunnable.start();
    }
}
