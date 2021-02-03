package com.pascal.util.excelutil;

//WHAT CAN I DO
public class LogWrite {

    public LogWrite() {
    }

    public LogWrite(String s) {
        System.out.println("Constructor with a string:" + s);
    }

    public LogWrite(String s, int i) {
        this(s);
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        long ll = Runtime.getRuntime().maxMemory();
        System.out.printf(String.valueOf(ll));
        int ii = Runtime.getRuntime().availableProcessors();
        System.out.println("ii = " + ii);
        LogWrite lw = new LogWrite();
        LogWrite lwa = new LogWrite();
        LogWrite lwb = new LogWrite("bb", 3);
        Math.round(11.5);
        Math.round(-11.5);
        System.out.println("Math.round(11.5); = " + Math.round(11.5));
        System.out.println("Math.round(11.5); = " + Math.round(-11.5));
        System.out.printf(lw.getLogWrite().toString());
        System.out.printf(lwb.getLogWrite().toString());
    }

    public Object getLogWrite() {
        return this;
    }
}
