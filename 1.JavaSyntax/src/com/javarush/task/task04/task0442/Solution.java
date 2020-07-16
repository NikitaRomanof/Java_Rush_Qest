package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int y = 0;
        for (; true; ) {

            int x = Integer.parseInt(reader.readLine());

y = y+x;

            if (x==-1)
                break;
           //напишите тут ваш код

        }
        System.out.println(y);
    }
}
