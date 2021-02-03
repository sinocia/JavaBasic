package com.pascal.javabasic.thread.notify;
/**
 * Created by Pascal on 2017/12/15 0015.
 */

import java.util.LinkedList;
import java.util.Queue;

public class ConsumerProducer {

    public static void main(String args[]) {
        final Queue sharedQ = new LinkedList();
        System.out.println("sharedQ.size = "+sharedQ.size());
        Thread producer = new Producer(sharedQ);
        Thread consumer = new Consumer(sharedQ);
        producer.start();
        consumer.start();
    }
}



