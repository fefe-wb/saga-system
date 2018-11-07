package com.wb.system.util.algorithm;

import java.util.Random;
public class SlopeUp {
    public static void main(String[] args) {
        int count=10;//测试30个数据
        int[] nums=new int[count];
        Random random=new Random();
        for(int i=0;i<count;i++){
            nums[i]=random.nextInt(100);
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        new SlopeUp().process(nums);
    }

    private int[] a; //a[i]表示从开始到i最长连续递增子序列个数，最后的结果为:a[a.length-1]
    private int[] b; //b[i]表示到当前i位置有多少个连续递增个数，如-1,2,4,0,3 则b[2]=3;b[4]=2
    public void process(int[] nums){
        a=new int[nums.length];
        b=new int[nums.length];
        for(int i=1;i<nums.length;i++){

            if(nums[i]>nums[i-1]){
                b[i]=b[i-1]+1;
                if(b[i]+1>a[i-1]){
                    System.out.println("The End Number Is:"+nums[i]);
                    a[i]=b[i]+1;
                }else{
                    a[i]=a[i-1];
                }
            }else{
                a[i]=a[i-1];
            }
        }
        System.out.println(a[a.length-1]);
    }

}
