package com.wb.system.util.algorithm;

public class InsertionSort {

    /**
     * 时间复杂度：
     * 平均：O(n²)
     * 最好：O(n)
     * 最坏：O(n²)
     * @param a
     */
//    public static void insertSortMethod(int[] a) {
//        int i,j,x;
//        for (j=1;j<a.length;j++) {
//            i = j - 1;
//            x = a[j];
//            while (i>=0 && a[i] > x) {
//                a[i+1] = a[i];
//                i--;
//            }
//            a[i+1] = x;
//        }
//    }

//    public static void insertSortMethod(int[] a) {
//        int i,j,temp;
//        for (i=1;i<a.length;i++) {
//            j = i-1;
//            temp = a[i];
//            while (j >= 0 && a[j] > temp) {
//                a[j+1] = a[j];
//                j--;
//            }
//            a[j+1] = temp;
//        }
//    }

//    public static void insertSortMethod(int[] a) {
//        int i,j,temp;
//        for (i=1;i<a.length;i++) {
//            j = i-1;
//            temp = a[i];
//            while (j >= 0 && a[j] > temp) {
//                a[j+1] = a[j];
//                j--;
//            }
//            a[j+1] = temp;
//        }
//    }

    public static void insertSortMethod(int[] a) {
        int i,j,temp;
        for (i=1;i<a.length;i++) {
            j = i-1;
            temp = a[i];
            while (j >= 0 && a[j] > temp) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }
    }
}
