package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String>[] aa = new ArrayList[2];
        ArrayList<String> a = new ArrayList<>();
        a.add("werg");
        a.add("wserg");
        ArrayList<String> b = new ArrayList<>();
        b.add("wegwefwc");
        b.add("wegf");

        aa[0] = a;
        aa[1] = b;//напишите тут ваш код

        return aa ;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}