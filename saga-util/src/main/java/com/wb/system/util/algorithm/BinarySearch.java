package com.wb.system.util.algorithm;

public class BinarySearch {

    public static void main(String[] args) {
        int[] src = new int[] {1, 3, 5, 7, 7, 8, 9};
        System.out.println(binarySearch2(src, 7));
    }

    public static int binarySearch(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (target < a[mid]) {
                j = mid - 1;
            } else if (target > a[mid]) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearch1(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int start = 0, end = a.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target < a[mid]) {
                end = mid - 1;
            } else if (target > a[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

//    public static int binarySearch2(int[] a, int target) {
//        if (a == null || a.length == 0) {
//            return -1;
//        }
//        int start = 0;
//        int end = a.length - 1;
//        while (start <= end) {
//            int mid = (start + end) / 2;
//            if (target < a[mid]) {
//                end = mid - 1;
//            } else if (target > a[mid]) {
//                start = mid + 1;
//            } else {
//                return mid;
//            }
//        }
//        return -1;
    public static int binarySearch2(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target > a[mid]) {
                start = mid + 1;
            } else if (target < a[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
