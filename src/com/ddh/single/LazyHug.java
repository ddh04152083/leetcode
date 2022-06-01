package com.ddh.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 双重锁检验能保证线程安全，
 * volatile　防止指令重排，对象的创建不是原子性的，所以这里需要加入该关键字
 * １．申请内存空间
 * ２、执行构造方法，初始化
 * ３．把对象指向这个空间
 */
public class LazyHug {
    private LazyHug() {
        if (instance != null) {
            throw new RuntimeException("sdds");
        }
    }

    private static volatile LazyHug instance = null;

    public static LazyHug getInstance() {
        if (instance == null) {
            synchronized (LazyHug.class) {
                if (instance == null) {
                    instance = new LazyHug();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        LazyHug lazyHug = LazyHug.getInstance();
        System.out.println(lazyHug);

        Constructor<LazyHug> declaredConstructor = LazyHug.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyHug lazyHug1 = declaredConstructor.newInstance();
        System.out.println(lazyHug1);

    }
}
