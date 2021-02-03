package com.pascal.javabasic.jvm.initializeorder;

/**
 * Created by Pascal on 2017/12/19 0019.
 */
class Parent {
    //常量
    public static final String P_CONST = "父类--常量";
    // 静态变量
    public static String p_StaticField = "父类--静态变量";
    // 变量
    public String p_Field = "父类--变量";

    // 静态初始化块
    static {
        System.out.println("父类--静态初始化块");
        System.out.println(P_CONST);
        System.out.println(p_StaticField);
    }

    // 初始化块
    {
        System.out.println(p_Field);
        System.out.println("父类--初始化块");
    }

    // 构造器
    public Parent() {
        System.out.println("父类--构造器");
    }
}

public class SubClass extends Parent {
    //常量
    public static final String S_CONST = "子类--常量";
    // 静态变量
    public static String s_StaticField = "子类--静态变量";
    // 变量
    public String s_Field = "子类--变量";
    // 静态初始化块
    static {
        System.out.println(s_StaticField);
        System.out.println(S_CONST);
        System.out.println("子类--静态初始化块");
    }
    // 初始化块
    {
        System.out.println(s_Field);
        System.out.println("子类--初始化块");
    }

    // 构造器
    public SubClass() {
        System.out.println("子类--构造器");
    }

    // 程序入口
    public static void main(String[] args) {
        new SubClass();
    }
}
