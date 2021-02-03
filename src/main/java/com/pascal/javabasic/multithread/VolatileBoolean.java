package com.pascal.javabasic.multithread;

/**
 * @auther Pascal
 * @date 2020/11/3 20:04
 */
public class VolatileBoolean {
    private volatile boolean firstCompleted;
    private volatile boolean secondCompleted;

    public VolatileBoolean() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstCompleted = true;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (!firstCompleted) {

        }
        printSecond.run();
        secondCompleted = true;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (!secondCompleted) {

        }
        printThird.run();
    }
}
