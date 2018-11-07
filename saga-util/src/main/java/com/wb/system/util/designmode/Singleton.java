package com.wb.system.util.designmode;

public class Singleton {

    private static volatile Singleton singleton = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("wubing");
        stringBuffer.append("123");
        System.out.println(stringBuffer.toString());
    }
}
