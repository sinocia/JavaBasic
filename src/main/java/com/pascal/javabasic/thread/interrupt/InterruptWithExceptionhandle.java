package com.pascal.javabasic.thread.interrupt;

/**
 * @auther Pascal
 * @date 2020/11/7 15:59
 */
public class InterruptWithExceptionhandle implements Runnable {

    @Override
    public void run() {
        try {
            //System.out.println("running :"+Thread.interrupted());
            System.out.println("running : " + Thread.currentThread().isInterrupted());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("interrupted while sleeping");
            throw new RuntimeException("Interrupted , stop");
        }
        System.out.println(Thread.currentThread() + " is running");
    }

    public static void main(String[] args) {
        InterruptWithExceptionhandle interruptWithExceptionhandle = new InterruptWithExceptionhandle();
        Thread thread = new Thread(interruptWithExceptionhandle);
        //System.out.println("before started: " + thread.isInterrupted());
        thread.start();
        thread.interrupt();
        //System.out.println("after started: " + thread.isInterrupted());
    }
}
