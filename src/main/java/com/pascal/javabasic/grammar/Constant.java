package com.pascal.javabasic.grammar;

/**
 * @auther Pascal
 * @date 2020/11/16 11:03
 */
public class Constant {
    /**
     * If a primitive type or a string is defined as a constant and the value is known at compile time,
     * the compiler replaces the constant name everywhere in the code with its value.
     * This is called a compile-time constant. If the value of the constant in the outside world changes
     * (for example, if it is legislated that pi actually should be 3.975), you will need to
     * recompile any classes that use this constant to get the current value.
     */
    static final double PI = 3.14;
}

