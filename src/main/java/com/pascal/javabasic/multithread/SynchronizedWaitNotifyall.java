package com.pascal.javabasic.multithread;

/**
 * @auther Pascal
 * @date 2020/11/3 17:44
 */
public class SynchronizedWaitNotifyall {
    public int count;

    public SynchronizedWaitNotifyall() {
        this.count = 1;
    }

    synchronized public void first(Runnable printFirst) throws InterruptedException {
        while(count != 1) wait();

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        this.count++;
        notifyAll();
    }

    synchronized public void second(Runnable printSecond) throws InterruptedException {
        while(this.count != 2) wait();

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        this.count++;
        notifyAll();

    }

    synchronized public void third(Runnable printThird) throws InterruptedException {
        while(this.count != 3) wait();

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        this.count++;
        notifyAll();
    }
}
