package com.pascal.javabasic.multithread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther Pascal
 * @date 2020/11/3 20:06
 */
public class AtomicCounter {
    private final AtomicInteger count = new AtomicInteger(0);

    public AtomicCounter() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (count.get() != 0) {}
        printFirst.run();
        count.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (count.get() != 1) {}
        printSecond.run();
        count.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (count.get() != 2) {}
        printThird.run();
        count.set(0);
    }
}
