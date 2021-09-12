package com.ddh.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestSleep implements Runnable {
    private int ticketNums = 10;

    private boolean flag = true;

    private Lock lock = new ReentrantLock();

    @Override
    public synchronized void run() {
        while (flag) {
            lock.lock();
            if (ticketNums < 1) {
                this.flag = false;
                return;
            }
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + "--->拿到了第" + ticketNums-- + "张票");
            lock.unlock();
        }


    }

    public static void main(String[] args) {
        TestSleep ticket = new TestSleep();

        new Thread(ticket, "小明").start();
        new Thread(ticket, "老师").start();
        new Thread(ticket, "黄牛党").start();
    }
}
