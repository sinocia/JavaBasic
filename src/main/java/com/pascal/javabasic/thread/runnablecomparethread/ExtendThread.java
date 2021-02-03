package com.pascal.javabasic.thread.runnablecomparethread;

import java.util.ArrayList;

/**
 * @auther Pascal
 * @date 2020/11/4 15:36
 */
public class ExtendThread extends Thread {
    //todo
    private String name;
    private SharedResource sharedResource;

    public static SharedResource main = null;

    public static int numRunners = 4;
    public static ArrayList<Runner> runners = null;


    public ExtendThread(String threadName, SharedResource resource) {
        this.name = threadName;
        this.sharedResource = resource;
        runners = new ArrayList<Runner>(numRunners);

        for (int i = 0; i < numRunners; i++)
        {
            Runner r = new Runner();
            runners.add(r);
            new Thread(r).start();
        }

        System.out.println("Runners ready.");
        notifyAll();
    }

    class Runner implements Runnable
    {
        public void run()
        {
            try
            {
                ExtendThread.main.wait();
            } catch (InterruptedException e) {}
            System.out.println("Runner away!");
        }
    }
    @Override
    public void run() {
        synchronized (this) {
            //interrupt();
       /* try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IllegalMonitorStateException e){
            //啥都不做，异常被吃
            //打印堆栈
            e.printStackTrace();
            //抛出异常
            throw e;
        }*/
            System.out.println(this.name + " extendThreadName: " + sharedResource.getI());

            //interrupt();

            System.out.println(isInterrupted());
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("what");
    }

    public static void main(String[] args) {

        ExtendThread extendThread = new ExtendThread("test", new SharedResource(1));
        extendThread.start();
        synchronized (extendThread) {
            extendThread.notify();
        }
        //System.out.println("mainThread: " + interrupted());
        //extendThread.interrupt();
        //System.out.println("testThread: " + extendThread.isInterrupted());
    }
}
