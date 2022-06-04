package com.ddh.proxy;

public class UserServiceProxy {


    private UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    public void  add(){

        System.out.println("静态代理开启事务");
        userService.add();
        System.out.println("静态代理关闭事务");
    }

}
