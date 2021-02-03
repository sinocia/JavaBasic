package com.pascal.javabasic.string;

/**
 * Created by ${Pascal} on 2017/12/14 0014.
 */
public class Test {
    public int test() {
        int i = 0;
        try {
            System.out.println("i = " + i);
            return i = 2;
        } finally {
            i = 3;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        Test t = new Test();
        System.out.println(t.test());
    }
}
