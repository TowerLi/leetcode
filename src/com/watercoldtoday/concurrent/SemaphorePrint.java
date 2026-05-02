package com.watercoldtoday.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphorePrint {

    private static int count = 0;
    private static Semaphore sA = new Semaphore(1);
    private static Semaphore sB = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(() -> printTask(sA, sB), "线程1").start();
        new Thread(() -> printTask(sB, sA), "线程2").start();
    }

    private static void printTask(Semaphore current, Semaphore next) {
        while (count <= 100) {
            try {
                current.acquire();
                if (count <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                }
                next.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
