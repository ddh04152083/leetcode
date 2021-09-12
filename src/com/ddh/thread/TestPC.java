package com.ddh.thread;

public class TestPC {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        Productor productor = new Productor(synContainer);
        Comsumer comsumer = new Comsumer(synContainer);
        productor.start();
        comsumer.start();
    }
}


class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

class Productor extends Thread {

    private SynContainer synContainer;

    public Productor(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synContainer.push(new Chicken(i));
            System.out.println("生产了" + i + "只鸡");
        }
    }
}

class Comsumer extends Thread {

    private SynContainer synContainer;

    public Comsumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            System.out.println("消费了第" + synContainer.pop().id + "只鸡");
        }
    }
}

class SynContainer {

    Chicken[] chickens = new Chicken[10];

    int count = 0;

    public synchronized void push(Chicken chicken) {

        if (count == chickens.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count] = chicken;
        count++;
        this.notifyAll();

    }

    public synchronized Chicken pop() {

        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Chicken chicken = chickens[count];
        this.notifyAll();
        return chicken;
    }
}
