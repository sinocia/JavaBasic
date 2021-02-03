package com.pascal.javabasic.multithread.coordinate.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther Pascal
 * @date 2020/11/3 19:59
 */
public class Countdownlatch {
    CountDownLatch startLatch = new CountDownLatch(1);
    CountDownLatch endLatch = new CountDownLatch(6);
    private AtomicInteger integer=new AtomicInteger();

    public void doLogic() {
        integer.incrementAndGet();
    }

    class Worker implements Runnable {

        @Override
        public void run() {
            try {
                startLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            doLogic();
            endLatch.countDown();
        }
    }

    public void runSimulation() {
        for (int i = 0; i < 6; i++) {
            new Thread(new Worker()).start();
        }
    }

    public static void main(String[] args) {
        //do logic before let threads exec
        Countdownlatch countdownlatch = new Countdownlatch();
        countdownlatch.startLatch.countDown();
        countdownlatch.runSimulation();
        try {
            countdownlatch.endLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(countdownlatch.integer.get());
    }
}
