package com.ddh.thread.juc;

import java.util.concurrent.TimeUnit;

public class VolatileDemo1 {
    private static volatile int num = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (num == 0) {
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);


        num = 1;
        System.out.println(num);
    }

}
