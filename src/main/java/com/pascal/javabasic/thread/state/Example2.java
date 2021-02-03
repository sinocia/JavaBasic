package com.pascal.javabasic.thread.state;

/**
 * @auther Pascal
 * @date 2020/11/7 18:13
 */
public class Example2 {
    public static void main(String[] args) {
        MyTask2 t = new MyTask2();
        t.setName("Thread2");
        Example1.runExampleThread(t);
    }

    private static class MyTask2 extends Thread {
        @Override
        public void run() {
            Example1.printState("thread run() started", this);
            try {
                //this will put the thread in TIMED_WAITING state
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Example1.printState("thread finishing", this);
        }
    }
}
