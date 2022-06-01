package com.ddh.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 饿汉式是线程安全的
 * 但是存在漏洞，不是安全的的，可以通过在私有构造方法中进行为空判断，然后抛出异常解决
 *
 */
public class HugMan {
    private static final HugMan hugMan = new HugMan();


    private HugMan(){
        if (null != hugMan) {
            throw new RuntimeException();
        }
    }

    public static HugMan getInstance() {
        return hugMan;
    }
}


class Test1 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {


        System.out.println(HugMan.getInstance());
        Constructor<HugMan> constructor = HugMan.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        HugMan hugMan = constructor.newInstance();
        System.out.println(hugMan);

    }

}
