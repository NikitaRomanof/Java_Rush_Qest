package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    ArrayList<String> strings = new ArrayList<String>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    for(int i=0; i<5; i++){
        String s = reader.readLine();
        strings.add(i, s);

    }
    for(int i =0; i<13;i++){
        strings.add(0, strings.remove(strings.size()-1));
    }
    for(int i =0; i<strings.size();i++){
        System.out.println(strings.get(i));}

   //напишите тут ваш код
    }
}
