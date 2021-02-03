package com.pascal.javabasic.thread.interrupt;

/**
 * @auther Pascal
 * @date 2020/11/7 16:14
 */
public class InterruptWithStateusage implements Runnable {

    @Override
    public void run() {
        try {
            //System.out.println("running :"+Thread.interrupted());
            System.out.println("running : " + Thread.currentThread().isInterrupted());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Interruption occured");
        }
        if(Thread.currentThread().isInterrupted()){
            System.out.println("oh yeah");
        }else {
            System.out.println("hell no");
        }
        System.out.println(Thread.currentThread() + " is running");
    }

    public static void main(String[] args) {
        InterruptWithStateusage interruptWithStateusage = new InterruptWithStateusage();
        Thread thread = new Thread(interruptWithStateusage);
        System.out.println("before started: " + thread.isInterrupted());
        thread.start();
        thread.interrupt();
        System.out.println("after started: " + thread.isInterrupted());
    }
}
