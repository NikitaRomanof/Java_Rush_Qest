package com.javarush.task.task03.task0322;

/* 
Большая и чистая
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
      BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
      String Name1 = read.readLine();
      String Name2 = read.readLine();
      String Name3 = read.readLine();
      System.out.print(Name1 + " + " +  Name2 + " + " + Name3 + " = Чистая любовь, да-да!");

    }
}