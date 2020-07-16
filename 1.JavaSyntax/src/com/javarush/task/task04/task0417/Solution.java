package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
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
        if (a==b && a==c)
            System.out.println(a + " "+ b + " " + c);
        else if (a==c)
            System.out.println(a + " "+ c);
        else if (b==c)
            System.out.println(b + " "+ c);
        else if (a==b)
            System.out.println(a + " "+ b);
       //напишите тут ваш код

    }
}