package com.ddh.thread;

public class StopThread implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println(" run ");
        }

    }

    private void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {

        StopThread testThread = new StopThread();
        new Thread(testThread).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println(" main ");
            if (i == 900) {

                testThread.stop();
            }
        }
    }
}
