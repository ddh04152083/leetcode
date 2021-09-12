package com.ddh.thread.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 独占锁（写锁）一次只能被一个线程操作
 * 共享锁（读锁）　可以被多个线程同时占有
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        CacheLock cacheLock = new CacheLock();


        for (int i = 0; i < 5; i++) {
            int temp = i;
            new Thread(() -> cacheLock.put(String.valueOf(temp), String.valueOf(temp)), String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            int temp = i;
            new Thread(() -> cacheLock.get(String.valueOf(temp)), String.valueOf(i)).start();
        }
    }
}

class CacheLock {

    private volatile Map<String, String> map = new HashMap<>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, String value) {

        readWriteLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "开始写入：　" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入完毕　");
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public String get(String key) {

        String value;
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始读取：　" + key);
            value = map.get(key);
            System.out.println(Thread.currentThread().getName() + "开始完毕　");
        } finally {
            readWriteLock.readLock().unlock();
        }

        return value;
    }
}
