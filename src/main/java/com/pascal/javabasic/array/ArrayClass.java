package com.pascal.javabasic.array;

/**
 * Each Array's direct super class is Object ,and implement Cloneable and Serializable
 * Each Object is a Class instance or a Class
 * Array is not created by constructor , instead they are created dynamically at runtime.
 */

public class ArrayClass {
    static int[] a=  {1,2,3,4};


    public static void main(String[] args)
    {
        test(int[].class);
        test(String[].class);
        System.out.println(a.getClass());
    }

    static void test(Class clazz)
    {
        System.out.println(clazz.getName());
        System.out.println(clazz.getSuperclass());
        for(Class face : clazz.getInterfaces())
            System.out.println(face);
    }
}

