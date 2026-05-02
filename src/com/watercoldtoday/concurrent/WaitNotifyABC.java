package com.watercoldtoday.concurrent;

import javax.swing.*;

public class WaitNotifyABC {
    private static final Object LOCK = new Object();
    private static int state = 0;

    public static void main(String[] args) {
        new Thread(() -> print("A", 0)).start();
        new Thread(() -> print("B", 1)).start();
        new Thread(() -> print("C", 2)).start();
    }

    private static void print(String name, int target) {
        for (int i = 0; i < 10; i++) {
            synchronized (LOCK) {
                while (state % 3 != target) {
                    try{
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(name);
                if (i < 9 && state % 3 == 2) {
                    System.out.print(",");
                }
                state++;
                LOCK.notifyAll();
            }
        }
    }
}
