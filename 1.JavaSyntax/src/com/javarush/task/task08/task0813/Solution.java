package com.javarush.task.task08.task0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static Set<String> createSet() throws IOException {
      Set<String> strings = new HashSet<>();
       for(int i =0; i<20;i++){
           strings.add("");
       }
      return strings;
      //напишите тут ваш код

    }

    public static void main(String[] args) throws IOException {
       createSet();

    }
}
