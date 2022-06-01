package com.ddh.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum EnumSingle {
    INSTANCE;

    public static EnumSingle getInstance() {
        return INSTANCE;
    }


}
class Test{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        System.out.println(EnumSingle.getInstance());
        EnumSingle enumSingle = declaredConstructor.newInstance();
        System.out.println(enumSingle);
    }
}