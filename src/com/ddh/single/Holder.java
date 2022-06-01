package com.ddh.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 匿名内部类
 *
 *  匿名内部类是线程安全的，但是存在漏洞，反射可以进行破坏
 *
 */
public class Holder {

    private Holder() {
    }

    public static Holder getInstance(){
        return InnerClass.getInstance();
    }
    private static class InnerClass {

        private static Holder getInstance() {
            return new Holder();
        }
    }
}
class DemoTest{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<Holder> declaredConstructor = Holder.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        System.out.println(Holder.getInstance());
        Holder holder = declaredConstructor.newInstance();
        System.out.println(holder);

    }
}