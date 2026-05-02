package com.watercoldtoday.concurrent;

public class Singleton {

    private static volatile Singleton instance;

    public Singleton() {
        System.out.println(Thread.currentThread().getName() + "执行构造方法");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
