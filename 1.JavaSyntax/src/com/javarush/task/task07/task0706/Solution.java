package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
     int[] arrInt15 = new int[15];
     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     for(int i =0; i<arrInt15.length; i++){
         arrInt15[i]= Integer.parseInt(reader.readLine());
        }
     int sum1=0;
     int sum2=0;
     for(int i=1; i<arrInt15.length;i++){
         if (i%2==1){
             sum1 = sum1 + arrInt15[i];}
         else
             sum2 = sum2 + arrInt15[i];
         }
       if(sum1>sum2) {
     System.out.println("В домах с нечетными номерами проживает больше жителей.");}
       else
        System.out.println("В домах с четными номерами проживает больше жителей.");

     }     //напишите тут ваш код
    }

