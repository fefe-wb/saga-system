package com.wb.system.util.algorithm;

public class BubbleSort {

    /**
     * 时间复杂度：
     * 平均：O(n²)
     * 最好：O(n)
     * 最坏：O(n²)
     * @param a
     */
//    public static void BubbleSortMethod(int[] a) {
//        int temp;
//        for (int i=0;i<a.length;i++) {
//            for (int j=0;j<a.length-1-i;j++) {
//                if (a[j+1] < a[j]) {
//                    temp = a[j+1];
//                    a[j+1] = a[j];
//                    a[j] = temp;
//                }
//            }
//        }
//    }

//    public static void BubbleSortMethod(int[] a) {
//        int i,j,temp;
//        for (i=0;i<a.length;i++) {
//            for (j=0;j<a.length-1-i;j++) {
//                if (a[j] > a[j+1]) {
//                    temp = a[j];
//                    a[j] = a[j+1];
//                    a[j+1] = temp;
//                }
//            }
//        }
//    }

    public static void BubbleSortMethod(int[] a) {
        int temp;
        for (int i=0;i<a.length;i++) {
            for (int j=0;j<a.length-1-i;j++) {
                if (a[j] > a[j+1]) {
                    temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
