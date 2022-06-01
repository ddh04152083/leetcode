package com.ddh.annotation;

public class ReflectTest {

    @Reflect(name = "ddh")
    public static void sayHello(final String name){

        System.out.println("=============>"+name);
    }

    public static void main(String[] args) throws Exception {
        final ReflectProcessor relectProcessor = new ReflectProcessor();
        relectProcessor.parseMethod(ReflectTest.class);
    }
}
