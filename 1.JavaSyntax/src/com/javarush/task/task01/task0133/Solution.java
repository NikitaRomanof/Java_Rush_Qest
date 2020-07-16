package com.javarush.task.task01.task0133;

/* 
Не думать о секундах…
*/

public class Solution {
    public static void main(String[] args) {
        int secondsAfter15 = 0;
        double x = 15.00*60;
        double y = 15.50*60;
        secondsAfter15 =secondsAfter15 + (int) ((y-x)*60);

        System.out.println(secondsAfter15);
    }
}