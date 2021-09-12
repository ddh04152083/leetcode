package com.ddh.thread.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程循环打印Ａ、Ｂ、Ｃ
 */
public class PCTestC {
    public static void main(String[] args) {
        Data3 data = new Data3();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

    }
}

class Data3 {

    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    private int number = 1;

    public void printA() throws InterruptedException {
        lock.lock();
        try {

            while (number != 1) {
                //等待
                conditionA.await();
            }


            System.out.println(Thread.currentThread().getName() + "=>AA");
            //唤醒指定的执行Ｂ
            number = 2;
            conditionB.signal();


        } finally {
            lock.unlock();
        }
    }

    public void printB() throws InterruptedException {
        lock.lock();
        try {
            while (number != 2) {
                //等待
                conditionB.await();
            }

            System.out.println(Thread.currentThread().getName() + "=>BB");
            //唤醒指定的执行C
            number = 3;
            conditionC.signal();
        } finally {
            lock.unlock();
        }
    }

    public void printC() throws InterruptedException {
        lock.lock();
        try {
            while (number != 3) {
                //等待
                conditionC.await();
            }

            System.out.println(Thread.currentThread().getName() + "=>CC");
            number = 1;
            conditionA.signal();
        } finally {
            lock.unlock();
        }
    }

}
