package com.pascal.javabasic.multithread.coordinate.cyclicbarrier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @auther Pascal
 * @date 2020/11/3 20:25
 */
public class CyclicBarrierDemo {
    private CyclicBarrier cyclicBarrier;
    private int THEAD_NUM;
    private int PARTIAL_RESULT_NUM;
    private List<List<Integer>> allResults = Collections
            .synchronizedList(new ArrayList<>());
    Random random = new Random();

    class Worker implements Runnable {
        List<Integer> partialResult = new ArrayList<>();

        @Override
        public void run() {
            for (int i = 0; i < PARTIAL_RESULT_NUM; i++) {
                int j = random.nextInt(10);
                partialResult.add(j);
            }
            allResults.add(partialResult);
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("worker end");
        }
    }

    class AggregatorThread implements Runnable {
        int sum = 0;

        @Override
        public void run() {
            System.out.println("aggregator starts");
            for (List<Integer> result : allResults) {
                for (Integer integer : result) {
                    sum += integer;
                }
            }
            System.out.println("sum: " + sum);
        }
    }

    public void runSimulation(int threadNum, int partialResultNum) {
        THEAD_NUM = threadNum;
        PARTIAL_RESULT_NUM = partialResultNum;
        cyclicBarrier = new CyclicBarrier(threadNum, new AggregatorThread());
        for (int i = 0; i < THEAD_NUM; i++) {
            new Thread(new Worker()).start();
        }
        System.out.println(cyclicBarrier.getNumberWaiting());
        //cyclicBarrier.reset();
        System.out.println(cyclicBarrier.getNumberWaiting());

    }

    public static void main(String[] args) {
        CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo();
        cyclicBarrierDemo.runSimulation(5, 8);
    }
}
