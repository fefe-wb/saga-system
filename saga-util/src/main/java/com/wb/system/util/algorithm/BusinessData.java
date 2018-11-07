package com.wb.system.util.algorithm;

public class BusinessData {

    private static int[] a = {99,-1,8,0,-22,5,88,66,-2,-22};


    public static void main(String[] args) {
        printArray(a);
        InsertionSort.insertSortMethod(a);
//        BubbleSort.BubbleSortMethod(a);
//        SelectionSort.selectionSort(a);
//        QuickSort.quick_sort(a,0, a.length-1);
        printArray(a);
    }


    public static void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static void quick_sort(int[] a, int l, int r) {
        if (l < r) {

            int i = l;
            int j = r;
            int temp = a[l];

            while (i < j) {
                while (i < j && a[j] > temp) {
                    j --;
                }
                if (i < j) {
                    a[i] = a[j];
                    i ++;
                }
                while (i < j && a[i] < temp) {
                    i ++;
                }
                if (i < j) {
                    a[j] = a[i];
                    j --;
                }
            }
            a[i] = temp;
            quick_sort(a, l, i - 1);
            quick_sort(a, i + 1, r);
        }
    }
}
