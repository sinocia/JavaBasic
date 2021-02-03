package com.pascal.javabasic.thread.notify;

import java.util.Queue;

/**
 * Created by Pascal on 2017/12/15 0015.
 */
public class Consumer extends Thread {
    //private static final Logger logger = Logger.getLogger(Consumer.class);
    private final Queue sharedQ;

    public Consumer(Queue sharedQ) {
        super("Consumer");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedQ) {
                //waiting condition - wait until Queue is not empty
                //System.out.println("Queue is full, waiting");
                System.out.println("sharedQ.size = "+sharedQ.size());
                while (sharedQ.size() == 0) {
                    try {
                        //logger.debug("Queue is empty, waiting");
                        System.out.println("Queue is empty, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                int number = (int) sharedQ.poll();
                //logger.debug("consuming : " + number);
               System.out.printf("consuming : " + number+"\t\n");
                sharedQ.notify();
                //termination condition
                if (number == 3) {
                    break;
                }
            }
        }
    }
}
