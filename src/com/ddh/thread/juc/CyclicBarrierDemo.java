package com.ddh.thread.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(6, () -> System.out.println(" game over"));

        for (int i = 1; i <= 6; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " :" + finalI);
                try {
                    cyclicBarrier.await(); //等待
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
                    , String.valueOf(i)).start();

        }


    }
}
