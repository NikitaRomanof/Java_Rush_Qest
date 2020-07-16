package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
     ArrayList<String> strings = new ArrayList<String>();
     strings.add("мама");
     strings.add("мыла");
     strings.add("раму");
     strings.add(1,"именно");
     strings.add(3,"именно");
     strings.add(5,"именно");
     for(int i=0; i<strings.size(); i++){
         System.out.println(strings.get(i));
     }//напишите тут ваш код
    }
}
