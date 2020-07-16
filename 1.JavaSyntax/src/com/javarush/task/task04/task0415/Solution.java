package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String x,y,z;
       x = reader.readLine();
       y = reader.readLine();
       z = reader.readLine();
       int a,b,c;
       a = Integer.parseInt(x);
       b = Integer.parseInt(y);
       c = Integer.parseInt(z);
       if (a+b>a&b+c>a&a+c>a&a+b>b&b+c>b&a+c>b&a+b>c&b+c>c&a+c>c)
           System.out.println("Треугольник существует.");
    else
        System.out.println("Треугольник не существует.");
    //напишите тут ваш код

    }
}