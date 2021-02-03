package com.pascal.javabasic.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther Pascal
 * @date 2020/11/3 17:35
 */
public class LockCondition {
    final Lock lock = new ReentrantLock();
    final Condition cond2  = lock.newCondition();
    final Condition cond3  = lock.newCondition();
    volatile int count=1;

    public LockCondition() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            printFirst.run(); // printFirst.run() outputs "first". Do not change or remove this line.
            count++;
            cond2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while(count!=2){
                // waiting on the condition backed by same lock
                cond2.await();
            }

            printSecond.run(); // printSecond.run() outputs "second". Do not change or remove this line.
            count++;
            cond3.signal();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while(count!=3){
                // waiting on the condition backed by same lock
                cond3.await();
            }
            printThird.run(); // printThird.run() outputs "third". Do not change or remove this line.
        } finally {
            lock.unlock();
        }
    }
}
