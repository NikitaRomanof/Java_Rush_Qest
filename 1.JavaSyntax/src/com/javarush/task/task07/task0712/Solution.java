package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> strings = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            strings.add(s);
        }
        //System.out.println(strings);
        int max = 0;
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() > max) {
                max = strings.get(i).length();
            }
        }
        //System.out.println(max);
        int min = 2147483647;
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() < min) {
                min = strings.get(i).length();
            }
        }
       // System.out.println(min);
        for(int i =0; i<strings.size(); i++) {
            if (strings.get(i).length() >= max) {
                System.out.println(strings.get(i));
                break;
            } else if (strings.get(i).length() <= min) {
                System.out.println(strings.get(i));
                break;
            }
        }
    }
}
