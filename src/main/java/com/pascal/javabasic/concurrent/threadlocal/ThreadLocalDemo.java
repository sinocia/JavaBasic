package com.pascal.javabasic.concurrent.threadlocal;

/**
 * @auther Pascal
 * @date 2020/11/9 9:12
 *
 * 实现单个线程单例以及单个线程上下文信息存储，比如交易id等
 * 实现线程安全，非线程安全的对象使用ThreadLocal之后就会变得线程安全，因为每个线程都会有一个对应的实例
 * 承载一些线程相关的数据，避免在方法中来回传递参数
 */
public class ThreadLocalDemo implements Runnable{

    //todo 其它使用场景
    static ThreadLocal<String> threadLocal=new ThreadLocal<>();
    public ThreadLocalDemo(String id){
        threadLocal.set(id);
    }
    @Override
    public void run() {
         submitOrder(); //提交订单
         payment();  //支付
         shipment();  //发货
    }

    void  submitOrder(){
        threadLocal.get();
        //do logic
    }
    void payment(){
        threadLocal.get();
        //do logic
    }
    void shipment(){
        threadLocal.get();
        //do logic
    }
}
