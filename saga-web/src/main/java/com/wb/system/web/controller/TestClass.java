package com.wb.system.web.controller;


class SingleTon {
    private static SingleTon singleTon = new SingleTon();
    public static int count1;
    public static int count2 = 0;

    private SingleTon() {
        count1++;
        count2++;
    }

    public static SingleTon getInstance() {
        return singleTon;
    }
}

public class TestClass {
    public static void main(String[] args) {
//        SingleTon singleTon = SingleTon.getInstance();
//        System.out.println("count1=" + singleTon.count1);
//        System.out.println("count2=" + singleTon.count2);

//        String s1 = "abc";
//        String s2 = "abc";
//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));

        System.out.println("-----------");


        Integer i1 = new Integer(97);
        Integer i2 = new Integer(97);
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));        //false
        System.out.println("-----------");

        Integer i3 = new Integer(197);
        Integer i4 = new Integer(197);
        System.out.println(i3 == i4);
        System.out.println("-----------");        //false

        Integer i5 = 97;
        Integer i6 = 97;
        System.out.println(i5 == i6);
        System.out.println("-----------");        //true

        Integer i7 = 197;
        Integer i8 = 197;
        System.out.println(i7 == i8);            //false


    }
}
