package com.pascal.javabasic.jvm.initializeorder;

/**
 * Created by Pascal on 2017/12/19 0019.
 */
public class InitialOrderTest {
    //常量
    public static final String S_CONST = "常量";
    // 静态变量
    public static String staticField = "静态变量";
    // 变量
    public String field = "变量";
    // 初始化块
    {
        System.out.println(field);
        System.out.println("初始化块");
    }

    // 静态初始化块
    static {
        System.out.println(staticField);
        System.out.println("静态初始化块");
        System.out.println(S_CONST);
    }
    //常量





    // 构造器
    public InitialOrderTest() {
        System.out.println("构造器");
    }

    public static void main(String[] args) {
        new InitialOrderTest();
    }
}
