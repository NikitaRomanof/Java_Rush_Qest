package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
     int [] arrInt20 = new int[20];
     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     for (int i=0; i<arrInt20.length; i++) {
         arrInt20[i] = Integer.parseInt(reader.readLine());
        }
     int[] arrIntOne10 =new int[10];
     int[] arrIntTwo10 = new int[10];

     for (int i=0; i<arrIntOne10.length; i++){
         arrIntOne10[i]=arrInt20[i];
         arrIntTwo10[i]=arrInt20[10+i];
         //System.out.print(arrIntOne10[i]);
         System.out.println(arrIntTwo10[i]);
     }//напишите тут ваш код
    }
}
