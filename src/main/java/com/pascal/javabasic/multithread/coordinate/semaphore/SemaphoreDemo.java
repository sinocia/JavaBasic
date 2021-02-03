package com.pascal.javabasic.multithread.coordinate.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @auther Pascal
 * @date 2020/11/14 16:04
 */
public class SemaphoreDemo {
    static class Worker implements Runnable{

        Worker(int i,Semaphore semaphore){
            this.i=i;
            this.semaphore=semaphore;
        }
        private int i;
        private Semaphore semaphore;
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人"+this.i+"正在占用一台机器");
                Thread.sleep(2000);
                System.out.println("工人"+this.i+"释放一台机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(5);
        for (int i = 0; i < 8; i++) {
            new Thread(new Worker(i,semaphore)).start();
        }
    }
}
