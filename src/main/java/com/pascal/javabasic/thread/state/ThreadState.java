package com.pascal.javabasic.thread.state;

/**
 * @auther Pascal
 * @date 2020/11/4 16:51
 */
public class ThreadState implements Runnable {

    //NEW RUNNABLE BLOCKED WAITING TERMINATE
    /**
     * 没有running状态，运行在的thread的状态也是runnable
     *
     *     /**
     *      * The thread will be in this state when it calls wait() or join() method.
     *      * The thread will remain in WAITING state until any other thread calls notify() or notifyAll().
     *      *
     *      *The thread will be in this state when it is notified by other thread but has not got the object lock yet.
     *      * /
     */
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println(Thread.currentThread().getName() + i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("running");
    }


    public static void main(String[] args) {
        ThreadState state = new ThreadState();
        Thread thread = new Thread(state, "thread");
        Thread test = new Thread(state, "test");

        System.out.println(thread.getState());
        thread.start();
        test.start();
        System.out.println(thread.getState());
        synchronized (state) {
            try {
                thread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(thread.getState());

    }
}



