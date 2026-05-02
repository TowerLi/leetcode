package com.watercoldtoday.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreABC {

    private static Semaphore sA = new Semaphore(1);
    private static Semaphore sB = new Semaphore(0);
    private static Semaphore sC = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(() -> print("A", sA, sB)).start();
        new Thread(() -> print("B", sB, sC)).start();
        new Thread(() -> print("C", sC, sA)).start();
    }

    private static void print(String name, Semaphore current, Semaphore next) {
        for (int i = 0; i < 10; i++) {
            try {
                current.acquire();
                System.out.print(name);
                if (i < 9 && current.equals(sC)) {
                    System.out.print(",");
                }
                next.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
