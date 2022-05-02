package com.michal.kuc;

import java.util.Random;

public class Zad1 {
    public static void bubbleSort(Integer[] arr) {
        int bound = arr.length;
        int cache;
        while (bound > 0) {
            for (int i = 0; i < bound - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    cache = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = cache;
                }
            }
            bound--;
        }
    }

    public static void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            int cache;
            int i = low;
            int j = high;
            while (i < j) {
                if (arr[i] > arr[high]) {
                    j--;
                    cache = arr[j];
                    arr[j] = arr[i];
                    arr[i] = cache;
                } else {
                    i++;
                }
            }
            cache = arr[i];
            arr[i] = arr[high];
            arr[high] = cache;

            quickSort(arr, low, i - 1);
            quickSort(arr, i + 1, high);
        }
    }

    public static void printArray(Integer[] arr) {
        System.out.print("{ ");
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("}\n");
    }

    public static Integer[] genArray(int n) {
        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(20);
        }
        return arr;
    }
}

