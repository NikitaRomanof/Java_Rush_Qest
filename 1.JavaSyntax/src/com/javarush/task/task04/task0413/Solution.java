package com.javarush.task.task04.task0413;
/*
День недели
*/
import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String x = reader.readLine();
       int y = Integer.parseInt(x);
       if (y==1)
           System.out.println("понедельник");
       else if (y==2)
           System.out.println("вторник");
       else if (y==3)
           System.out.println("среда");
       else if (y==4)
           System.out.println("четверг");
       else if (y==5)
           System.out.println("пятница");
       else if (y==6)
           System.out.println("суббота");
       else if (y==7)
           System.out.println("воскресенье");
       else if(y<1 || y>7)
           System.out.println("такого дня недели не существует"); //напишите тут ваш код

    }
}