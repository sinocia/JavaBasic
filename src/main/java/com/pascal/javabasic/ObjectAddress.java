package com.pascal.javabasic;

public class ObjectAddress {

        long width;
        public ObjectAddress(long l) {
            width = l;
        }
        public static void main(String arg[]) {
            ObjectAddress a, b, c;
            a = new ObjectAddress(42L);
            b = new ObjectAddress(42L);
            c = b;
            long s = 42L;
            System.out.print(a+"\n");
            System.out.print(b+"\n");
            System.out.print(c+"\n");
            System.out.print(a==b);
            System.out.print(b==c);
            System.out.print(a.equals(s));
        }
    }

