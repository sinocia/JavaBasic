package com.pascal.javabasic.grammar;

/**
 * @auther Pascal
 * @date 2020/12/24 7:24
 */
public class TryCatchFinally {

    public static int test() {
        int i = 0;
        try {
            int j = 1;
            //int m=j/i;
            System.out.println(i);
            return i;

        } catch (Exception e) {
            e.printStackTrace();

            return i;

        } finally {

            i++;
            System.out.println(i);
            return i;

        }

    }

    public static void main(String[] args) {

        int m=TryCatchFinally.test();
        System.out.println(m);
    }
}
