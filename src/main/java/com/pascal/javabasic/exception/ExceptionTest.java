package com.pascal.javabasic.exception;

/**
 * Created by Pascal on 2017/12/14 0014.
 */

class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}

public class ExceptionTest {

    public static void main(String[] args)
            throws Exception {
        try {
            try {
                throw new Sneeze();
            } catch (Annoyance a) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        } catch (Sneeze s) {
            System.out.println("Caught Sneeze");
            return;
        } finally {
            System.out.println("Hello World!");
        }
    }
}

