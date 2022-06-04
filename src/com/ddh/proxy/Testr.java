package com.ddh.proxy;

import java.lang.reflect.Proxy;

public class Testr {


    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserServiceProxy userServiceProxy = new UserServiceProxy(userService);
        userServiceProxy.add();


        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(userService);

        UserService o = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(),
                invocationHandler);
        o.add();



    }
}
