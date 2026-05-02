package com.watercoldtoday.concurrent;

import java.util.concurrent.CountDownLatch;

public class SingletonTest {

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        CountDownLatch latch = new CountDownLatch(1);
        CountDownLatch finish = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                try {
                    latch.await();
                    Singleton singleton = Singleton.getInstance();
                    System.out.println(Thread.currentThread().getName() + " 获取实例： " + singleton.hashCode());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    finish.countDown();
                }
            }).start();
        }
        System.out.println("---10个线程同时竞争单例---");
        latch.countDown();
        finish.await();
        System.out.println("---测试结束---");
    }
}
