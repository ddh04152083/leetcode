package com.ddh.thread.juc;

import org.omg.SendingContext.RunTime;

import java.util.concurrent.*;

/**
 * new ThreadPoolExecutor.AbortPolicy() //　超过最大线程数不处理，抛出异常
 * new ThreadPoolExecutor.CallerRunsPolicy() //哪里创建的线程丢到哪里去执行
 * new ThreadPoolExecutor.DiscardPolicy() //队列满了，丢掉任务不会抛出异常
 * new ThreadPoolExecutor.DiscardOldestPolicy() //队列满了尝试和最早的线程去竞争，替换最早的线程不会抛出异常
 *
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {

        Executors.newFixedThreadPool(1);
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService service = new ThreadPoolExecutor(2, //核心线程数
                Runtime.getRuntime().availableProcessors(),//最大线程数
                3, //多久线程池超多核心线程数未使用后回收 空闲线程回收时间间隔
                TimeUnit.SECONDS,// 超时单位
                new LinkedBlockingDeque<>(3),//阻塞队列

                Executors.defaultThreadFactory(),//创建线程工厂方法
                new ThreadPoolExecutor.DiscardOldestPolicy()//拒绝策略
        );
        try {
            //最大承载数　deque +max
            for (int i = 1; i <= 8; i++) {

                service.submit(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(4);
                        System.out.println(Thread.currentThread().getName() + " ok!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                });


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}
