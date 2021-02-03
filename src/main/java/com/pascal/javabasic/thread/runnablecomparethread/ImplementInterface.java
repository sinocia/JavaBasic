package com.pascal.javabasic.thread.runnablecomparethread;

/**
 * @auther Pascal
 * @date 2020/11/4 10:21
 *
 * Runnable类中包含一个Thread引用的好处及应用场景是什么?
 */
public class ImplementInterface implements Runnable {
    private String threadName;
    private SharedResource sharedResource;

    public ImplementInterface(String name, SharedResource resource) {
        this.threadName = name;
        this.sharedResource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedResource.increment();
            System.out.println(threadName + " threadName:" + sharedResource.getI());
        }
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SharedResource resource = new SharedResource(0);
        for (int i = 0; i < 5; i++) {
            Thread worker = new Thread(new ImplementInterface(String.valueOf(i), resource));
            worker.start();
        }
        try {
            resource.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Thread extendThread = new ExtendThread("GetterThread", resource);
        //extendThread.start();

    }
}
