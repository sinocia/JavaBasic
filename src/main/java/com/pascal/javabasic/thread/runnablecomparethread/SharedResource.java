package com.pascal.javabasic.thread.runnablecomparethread;

/**
 * @auther Pascal
 * @date 2020/11/4 15:25
 */
public class SharedResource {
    private int i;

    public SharedResource(int i) {
        this.i = i;
    }

    public void increment() {
        this.i++;
    }

    public int getI(){
        return this.i;
    }
}
