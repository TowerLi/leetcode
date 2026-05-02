package com.watercoldtoday.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();

    private static int state = 0;

    public static void main(String[] args) {
        new Thread(() -> print("A", 0, conditionA, conditionB)).start();
        new Thread(() -> print("B", 1, conditionB, conditionC)).start();
        new Thread(() -> print("C", 2, conditionC, conditionA)).start();
    }

    private static void print(String name, int targetState, Condition current, Condition next) {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                while (state % 3 != targetState) {
                    current.await();
                }
                System.out.print(name);
                if (state % 3 == 2 && i < 9) {
                    System.out.print(",");
                }
                state++;
                next.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        }
    }
}
