package com.pascal.middleware.mq.rocketMQ;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther Pascal
 * @date 2020/11/26 9:14
 */
public class RocketDemo {
    //todo
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("a","a");
        map.put("b","b");
        System.out.println(String.valueOf(map.get(null)));

    }
}
