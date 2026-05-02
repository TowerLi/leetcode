package com.watercoldtoday.concurrent;

/**
 * 多线程赛跑模型 一个主线程 N个工作线程 。
 * 1. 所有运动员必须在枪响后开始
 * 2.直到最后一个运动员线程完毕后，主线程才可以做其他事情，否则一直等待.
 * 3.任一运动员子线程出现异常，其他所有子线程立即中断
 */
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RaceModel {
    private static final int N = 5; // 运动员数量
    private static final CountDownLatch startSignal = new CountDownLatch(1);
    private static final CountDownLatch finishSignal = new CountDownLatch(N);
    private static volatile boolean hasError = false; // 异常标志位

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(N);

        for (int i = 1; i <= N; i++) {
            final int id = i;
            executor.submit(() -> {
                try {
                    System.out.println("运动员 " + id + " 已就位，等待枪响...");
                    startSignal.await(); // 1. 枪响前禁止起跑

                    if (hasError) return;

                    // 模拟比赛过程
                    System.out.println("运动员 " + id + " 正在全力冲刺！");

                    // 模拟随机异常
                    if (id == 3) { // 假设3号运动员摔倒了（触发异常）
                        throw new RuntimeException("3号发生意外！");
                    }

                    Thread.sleep((long) (Math.random() * 2000));
                    System.out.println("运动员 " + id + " 到达终点。");

                } catch (Exception e) {
                    System.err.println("!!! 比赛异常: " + e.getMessage());
                    hasError = true;
                    executor.shutdownNow(); // 3. 立即尝试中断其他所有线程
                } finally {
                    finishSignal.countDown(); // 计数减一
                }
            });
        }

        // 主线程动作
        Thread.sleep(1000); // 准备阶段
        System.out.println(">> 砰！比赛开始！ <<");
        startSignal.countDown(); // 1. 发令枪响

        // 2. 等待所有人结束
        finishSignal.await();

        if (hasError) {
            System.out.println(">> 比赛因事故提前结束。 <<");
        } else {
            System.out.println(">> 所有运动员已过线，主线程开始结算成绩。 <<");
        }

        executor.shutdown();
    }
}