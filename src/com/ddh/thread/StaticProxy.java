package com.ddh.thread;

public class StaticProxy {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("123")).start();

        new WeddingMarry(new You()).happyMarry();
    }
}

interface Marry {
    void happyMarry();
}

class You implements Marry {
    @Override
    public void happyMarry() {
        System.out.println("结婚很高兴");
    }
}

class WeddingMarry implements Marry {

    private Marry marry;

    public WeddingMarry(Marry marry) {
        this.marry = marry;
    }

    @Override
    public void happyMarry() {
        this.before();
        this.marry.happyMarry();
        this.after();
    }

    private void before() {
        System.out.println("结婚前布置现场");
    }

    private void after() {
        System.out.println("结婚后收取费用");
    }
}
