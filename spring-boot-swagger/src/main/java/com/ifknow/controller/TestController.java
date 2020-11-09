package com.ifknow.controller;


import org.junit.Test;

/**
 * @author: GongShiYong <br>
 * @date: 2020/9/27  17:02 <br>
 * @description: NO Description
 */
public class TestController {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread();
        thread.setName("9-27-thread");
        Thread.sleep(5000);
        System.out.println("hahaha");
        thread.run();
        System.out.println(thread.getName());


    }

    @Test
    public void test01() {
        int diffDays = 0;
        double percent = 0.5;
        int baseMoney = 5000;
        int sunIncome = 999;
        long v = (long) (baseMoney + sunIncome * percent / diffDays);
        long m = (long) (baseMoney + sunIncome * percent);
        System.out.println(v);
        System.out.println(m);
        System.out.println(Long.MAX_VALUE);



    }
}
