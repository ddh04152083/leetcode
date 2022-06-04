package com.ddh.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandlerImpl implements InvocationHandler {

    private Object target;

    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result;

        System.out.println("动态代理开启   事务");
        result = method.invoke(target, args);
        System.out.println("动态代理关闭事务");
        return result;
    }
    public String cotact(String s1, String s2, String s3) {

        return s1 + s2 + s3;
    }
}
