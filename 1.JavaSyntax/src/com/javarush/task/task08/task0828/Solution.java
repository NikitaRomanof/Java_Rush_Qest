package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: "May is the 5 month".
Используйте коллекции.
Требования:
1. Программа должна считывать одно значение с клавиатуры.
2. Программа должна выводить текст на экран.
3. Программа должна использовать коллекции.
4. Программа должна считывать с клавиатуры имя месяца и выводить его номер на экран по заданному шаблону.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> calendar = new HashMap<>();
        calendar.put("January",1 );
        calendar.put("February",2 );
        calendar.put("March",3 );
        calendar.put("April",4 );
        calendar.put("May",5 );
        calendar.put("June",6 );
        calendar.put("July",7 );
        calendar.put("August",8 );
        calendar.put("September",9 );
        calendar.put("October",10 );
        calendar.put("November",11);
        calendar.put("December",12 );
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();
        for (Map.Entry<String, Integer> pair : calendar.entrySet())
        {
            String key = pair.getKey();                      //ключ
            int value = pair.getValue();
            if(month.equals(key)){
                System.out.print(key +" is the "+ value +" month");//значение
        }
        for(int i = 0; i<calendar.size(); i++){
            }
        }
    }
}
