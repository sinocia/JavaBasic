package com.pascal.javabasic.thread.interrupt;

/**
 * @auther Pascal
 * @date 2020/11/7 15:24
 *
 * 此情况下,interrupt()设置中断标记true,被中断线程抛出异常，且继续执行
 */
public class InterruptWithNothing implements Runnable {

    @Override
    public void run() {
        try {
            //System.out.println("running :"+Thread.interrupted());
            System.out.println("running : " + Thread.currentThread().isInterrupted());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Interruption occured");
        }
        System.out.println(Thread.currentThread() + " is running");
    }

    public static void main(String[] args) {
        InterruptWithNothing interruptWithNothing = new InterruptWithNothing();
        Thread thread = new Thread(interruptWithNothing);
        System.out.println("before started: " + thread.isInterrupted());
        thread.start();
        thread.interrupt();
        System.out.println("after started: " + thread.isInterrupted());
    }
}
