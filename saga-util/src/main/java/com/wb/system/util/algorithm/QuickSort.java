package com.wb.system.util.algorithm;

public class QuickSort {

    /**
     * 两个哨兵方法
     * @param left
     * @param right
     * @param a
     */
    public static void quickSort(int left,int right, int[] a) {
        int i,j,t,temp;
        if(left > right)
            return;

        temp = a[left]; //temp中存的就是基准数
        i = left;
        j = right;
        while(i != j) {
            //顺序很重要，要先从右边开始找
            while(a[j] >= temp && i < j)
                j--;
            //再找右边的
            while(a[i] <= temp && i < j)
                i++;
            //交换两个数在数组中的位置
            if(i <= j) {
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        //最终将基准数归位
        a[left] = a[i];
        a[i] = temp;

        quickSort(left,i-1, a);//继续处理左边的，这里是一个递归的过程
        quickSort(i+1,right, a);//继续处理右边的 ，这里是一个递归的过程
    }

    /**
     * 挖坑填数法
     * 时间复杂度：
     * 平均：O(nlogn)
     * 最好：O(nlogn)
     * 最坏：O(n²)
     * @param s
     * @param l
     * @param r
     */
    //快速排序
//    public static void quick_sort(int s[], int l, int r) {
//        if (l < r) {
//            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
//            int i = l, j = r, x = s[l];
//            while (i < j) {
//                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
//                    j--;
//                if(i < j)
//                    s[i++] = s[j];
//
//                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
//                    i++;
//                if(i < j)
//                    s[j--] = s[i];
//            }
//            s[i] = x;
//            quick_sort(s, l, i - 1); // 递归调用
//            quick_sort(s, i + 1, r);
//        }
//    }

//    public static void quick_sort(int s[], int l, int r) {
//        if (l < r) {
//            int i = l, j = r, temp = s[l];
//            while (i < j) {
//                while (i < j && s[j] >= temp) {
//                    j --;
//                }
//                if (i < j) {
//                    s[i++] = s[j];
//                }
//                while (i < j && s[i] < temp) {
//                    i ++;
//                }
//                if (i < j) {
//                    s[j--] = s[i];
//                }
//            }
//            s[i] = temp;
//            quick_sort(s, l, i - 1);
//            quick_sort(s, i + 1, r);
//        }
//    }

//    public static void quick_sort(int[] a, int l,int r) {
//        if (l < r) {
//            int i = l, j = r, temp = a[l];
//            while (i < j) {
//                while (i < j && a[j] > temp) {
//                    j--;
//                }
//                if (i < j) {
//                    a[i++] = a[j];
//                }
//                while (i < j && a[i] < temp) {
//                    i++;
//                }
//                if (i < j) {
//                    a[j--] = a[i];
//                }
//            }
//            a[i] = temp;
//            quick_sort(a, l, i-1);
//            quick_sort(a, i + 1, r);
//        }
//    }

    public static void quick_sort(int[] a, int l,int r) {
        if (l < r) {
            int i = l, j= r, temp = a[l];
            while (i < j) {
                while (i < j && a[j] > temp) {
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];
                }
                while (i < j && a[i] < temp) {
                    i ++;
                }
                if (i < j) {
                    a[j--] = a[i];
                }
            }
            a[i] = temp;
            quick_sort(a, l, i-1);
            quick_sort(a, i + 1, r);
        }
    }
}
