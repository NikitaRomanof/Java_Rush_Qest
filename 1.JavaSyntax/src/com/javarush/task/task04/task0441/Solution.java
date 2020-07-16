package com.javarush.task.task04.task0441;

/* 
Как-то средненько
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     int x = Integer.parseInt(reader.readLine());
     int y = Integer.parseInt(reader.readLine());
     int z = Integer.parseInt(reader.readLine());
     if ((x>=y && x<=z) || (x<=y && x>=z)){
         System.out.println(x);}
     else if ((y>=x && y<=z) || (y<=x && y>=z)) {
         System.out.println(y);}
     else if ((z>=y && z<=x) || (z<=y && z>=x) ) {
         System.out.println(z);}

     }//напишите тут ваш код

    }

