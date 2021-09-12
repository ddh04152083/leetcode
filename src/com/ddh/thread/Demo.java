package com.ddh.thread;

import java.util.concurrent.CopyOnWriteArrayList;

public class Demo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("11"));
        thread.setName("thread1: ");
        thread.start();

        System.out.println(thread.getName() + ": " + thread.getId());


    }
}
