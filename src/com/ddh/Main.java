package com.ddh;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        String s = new String("abc");
        Field value = s.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(s, "abcd".toCharArray());

        System.out.println(s);
        CountDownLatch count = new CountDownLatch(1);
        new Thread(() -> {
            count.countDown();
            System.out.println("count is : " + count.getCount());
        }).start();
        new Thread(() -> {
            try {
                count.await();
                System.out.println("唤醒了 " + count.getCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 10; i++) {
            int x = i;
            new Thread(() -> {

                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println(x + "车位获取到了锁");
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    semaphore.release();
                    System.out.println(x + "车位释放了锁");

                }


            }).start();
        }


    }
}
