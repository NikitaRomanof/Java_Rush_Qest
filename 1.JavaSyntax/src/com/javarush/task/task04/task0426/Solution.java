package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
    String a = reader.readLine();
    int x = Integer.parseInt(a);
    if(x<0 && x%2==0){
      System.out.print("отрицательное четное число");}
    else if (x<0 && x%2!=0){
        System.out.print("отрицательное нечетное число");}
    else if (x==0){
        System.out.print("ноль");}
    else if (x>0 && x%2==0){
        System.out.print("положительное четное число");}
    else if (x>0 && x%2!=0){
        System.out.print("положительное нечетное число"); }
    //напишите тут ваш код

    }
}
