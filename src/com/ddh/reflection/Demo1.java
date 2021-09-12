package com.ddh.reflection;

import java.lang.reflect.InvocationTargetException;

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Class.forName("com.ddh.reflection.User");
        User user = (User) clazz.newInstance();
        clazz.getMethod("setName", String.class).invoke(user, "ffh");
        System.out.println(clazz.getMethod("getName").invoke(user));
        System.out.println(clazz.getConstructors().length);
    }
}
