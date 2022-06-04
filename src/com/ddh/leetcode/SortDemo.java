package com.ddh.leetcode;

public class SortDemo {


    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) return;
        i = low;
        j = high;

        temp = arr[low];

        while (i < j) {
            while (temp <= arr[j] && i < j) {
                j--;

            }
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
            while (temp >= arr[i] && i < j) {
                i++;

            }
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }


        quickSort(arr, low, i - 1);
        quickSort(arr, j + 1, high);

    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {

            for (int j = 0; j < array.length - i - 1; j++) {

                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void selectSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            int min = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;

            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
//        quickSort(arr, 0, arr.length - 1);
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }
//        bubbleSort(arr);
        selectSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
