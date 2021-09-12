package com.ddh.thread.juc;

import java.util.concurrent.TimeUnit;

public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        Data4 data = new Data4();
        Data4 dat1 = new Data4();

        new Thread(() -> {
            try {
                data.prinA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> dat1.prinB()).start();
    }

}

class Data4 {

    public static synchronized void prinA() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("A");
    }

    public static synchronized void prinB() {
        System.out.println("B");
    }
}