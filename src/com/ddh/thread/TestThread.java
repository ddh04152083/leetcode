package com.ddh.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread extends Thread {

    private String url;
    private String name;

    public TestThread(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        new DownLoader().downLoader(url, name);
        System.out.println("下载文件名为" + name + "的文件");
    }

    public static void main(String[] args) {
        new TestThread("https://img0.baidu.com/it/u=1514002029,2035215441&fm=26&fmt=auto&gp=0.jpg", "1.jpg").start();
        new TestThread("https://img0.baidu.com/it/u=1079411485,1922124194&fm=26&fmt=auto&gp=0.jpg", "2.jpg").start();
        new TestThread("https://t7.baidu.com/it/u=963301259,1982396977&fm=193&f=GIF", "3.jpg").start();
        new TestThread("https://img01.dmhmusic.com/0207/M00/F9/C5/ChR462DoElaAaff1AAHh5zN62z8237.jpg@w_300,h_300", "4.jpg").start();
        new TestThread("https://dss0.bdstatic.com/-0U0bnSm1A5BphGlnYG/tam-ogel/f9d9c0c60f045466a614fc5dbe13373a_121_121.jpg", "5.jpg").start();
        new TestThread("https://i0.hdslb.com/bfs/live/new_room_cover/5ddcdd489e9a06b620254cd7bd47a2435ad30221.jpg@206w_116h_1c_100q.webp", "6.jpg").start();
     }
}


class DownLoader {

    public void downLoader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}