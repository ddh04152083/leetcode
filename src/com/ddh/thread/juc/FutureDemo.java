package com.ddh.thread.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int i = 1 / 0;
            return 1024;
        });
        System.out.println(future.whenComplete((t, u) -> {

            System.out.println("t=> " + t);
            System.out.println("u=> " + u);
        }).exceptionally(e -> {
            e.printStackTrace();
            return -1;
        }).get());
    }
}
