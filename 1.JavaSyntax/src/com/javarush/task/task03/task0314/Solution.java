package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        int x=1;
        int y;
        int z;

        while(x<=10){
            for(y=1; y<=10; y++)
                System.out.print(y*x+" ");
            System.out.println();

            x++;

        }

    }
}
