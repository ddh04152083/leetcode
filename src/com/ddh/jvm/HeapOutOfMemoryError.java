package com.ddh.jvm;


import java.util.ArrayList;
import java.util.List;

/**
 * vm args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * <p>
 * 将堆的最大值和最小值设为一样为了避免堆自动扩展
 */

public class HeapOutOfMemoryError {

    static class HeapOOM {

    }

    public static void main(String[] args) {

        List<HeapOOM> list = new ArrayList<>();
        while (true) {
            list.add(new HeapOOM());
        }
    }


}
