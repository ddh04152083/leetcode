package com.ddh.thread.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {

            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " Go Out");

                countDownLatch.countDown(); //数量减一
            }, String.valueOf(i)).start();


        }
        countDownLatch.await();// 等待计数器归零，然后向后面执行
        System.out.println("over");
    }
}
