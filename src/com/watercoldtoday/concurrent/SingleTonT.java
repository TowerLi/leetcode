package com.watercoldtoday.concurrent;

public class SingleTonT {

    private static volatile SingleTonT instance = null;

    private SingleTonT () {
        System.out.println("Creating");
    }

    public static SingleTonT getInstance() {
        if (instance == null) {
            synchronized(SingleTonT.class) {
                if (instance == null) {
                    instance = new SingleTonT();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        SingleTonT instance1 = SingleTonT.getInstance();
        SingleTonT instance2 = SingleTonT.getInstance();
        SingleTonT instance3 = SingleTonT.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        System.out.println(instance3.hashCode());
    }
}
