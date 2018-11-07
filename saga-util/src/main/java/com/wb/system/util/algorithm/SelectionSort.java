package com.wb.system.util.algorithm;

public class SelectionSort {

    /**
     * 时间复杂度：
     * 平均：O(n²)
     * 最好：O(n²)
     * 最坏：O(n²)
     * @param a
     */
//    public static void selectionSort(int[] a) {
//        int i,j,k,temp;
//        for (i=0;i<a.length;i++) {
//            k = i;
//            for (j=i+1;j<a.length;j++) {
//                if (a[k] > a[j]) {
//                    k = j;
//                }
//            }
//            temp = a[i];
//            a[i] = a[k];
//            a[k] = temp;
//        }
//    }

//    public static void selectionSort(int[] a) {
//        int i,j,k,temp;
//        for (i=0;i<a.length;i++) {
//            k = i;
//            for (j = i+1;j<a.length;j++) {
//                if (a[k] > a[j]) {
//                    k = j;
//                }
//            }
//            temp = a[i];
//            a[i] = a[k];
//            a[k] = temp;
//        }
//    }

//    public static void selectionSort(int[] a) {
//        int i, j, k, temp;
//        for (i = 0; i < a.length; i++) {
//            k = i;
//            for (j = i + 1; j < a.length; j++) {
//                if (a[j] < a[k]) {
//                    k = j;
//                }
//            }
//            temp = a[i];
//            a[i] = a[k];
//            a[k] = temp;
//        }
//    }

//    public static void selectionSort(int[] a) {
//        int i,j,k,temp;
//        for (i=0;i<a.length;i++) {
//            k=i;
//            for (j=i+1;j<a.length;j++) {
//                if (a[j] < a[k]) {
//                    k = j;
//                }
//            }
//            temp = a[i];
//            a[i] = a[k];
//            a[k] = temp;
//        }
//    }

    public static void selectionSort(int[] a) {
        int i,j,k,temp;
        for (i=0;i<a.length;i++) {
            k=i;
            for (j=i+1;j<a.length;j++) {
                if (a[j] < a[k]) {
                    k = j;
                }
            }
            temp = a[k];
            a[k] = a[i];
            a[i] = temp;
        }
    }
}
