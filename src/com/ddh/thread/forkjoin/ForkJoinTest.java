package com.ddh.thread.forkjoin;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //test1(); //sum = 500000000500000000 花费了: 11220
        //test2(); //sum = 500000000500000000 花费了: 9157
        //test3(); //sum = 500000000500000000 花费了: 530

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Integer result;

        result = list.stream().parallel().reduce((a, b) -> a * b).get();
        System.out.println(result);
        result = list.stream().parallel().reduce(2, (a, b) -> a * b);
        System.out.println(result);

        /*
         * (4,2,1,5,6,3) -> (8,4,2,10,12,6) -> ((8,(4,2)),(10,(12,6))) -> ((8,8),(10,24)) -> (24,58) -> 140
         */
        //1 3 9 8 5
        result = list.stream().parallel().reduce(0, (a, b) -> {
            System.out.println(Thread.currentThread().getName() + String.format(",a=%d,b=%d", a, b));
            return a + b * 2;
        });
         System.out.println(result);

        System.out.println(2*4*6*8*10);

    }

    //普通计算
    private static void test1() {

        long start = System.currentTimeMillis();
        Long sum = 0L;
        for (Long i = 0L; i <= 10_0000_0000; i++) {

            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum = " + sum + " 花费了: " + (end - start));
    }

    //forkjoin
    private static void test2() throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo task = new ForkJoinDemo(1L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        Long sum = submit.get();
        long end = System.currentTimeMillis();
        System.out.println("sum = " + sum + " 花费了: " + (end - start));
    }

    //并行流
    private static void test3() {

        long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum = " + sum + " 花费了: " + (end - start));
    }
}


