package com.pascal.javabasic.thread.notify;

import java.util.Queue;

/**
 * Created by Pascal on 2017/12/15 0015.
 */
public class Producer extends Thread {
    //private static final Logger logger = Logger.getLogger(Producer.class);
    private final Queue sharedQ;

    public Producer(Queue sharedQ) {
        super("Producer");
        this.sharedQ = sharedQ;
    }


    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            synchronized (sharedQ) {
                //waiting condition - wait until Queue is not empty
                System.out.println("sharedQ.size = "+sharedQ.size());
                while (sharedQ.size() >= 1) {
                    try {
                        //logger.debug("Queue is full, waiting");
                        System.out.println("Queue is full, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                //logger.debug("producing : " + i);
                System.out.printf("producing : " + i+"\t\n");
                sharedQ.add(i);
                sharedQ.notify();
            }
        }
    }
}
