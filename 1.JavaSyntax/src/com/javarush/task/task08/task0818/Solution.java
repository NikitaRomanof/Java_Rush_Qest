package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;
/*
Только для богачейСоздать словарь (Map<String, Integer>) и занести в него десять записей по принципу: "фамилия" - "зарплата".
Удалить из словаря всех людей, у которых зарплата ниже 500.
Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String, Integer состоящих из 10 записей по принципу «фамилия» - «зарплата».
4. Метод removeItemFromMap() должен удалять из словаря всех людей, у которых зарплата ниже 500.
*/
public class Solution {
    public static Map<String, Integer> createMap() {
       Map<String, Integer> map = new HashMap<>();
       map.put("Иванов1", 100);
        map.put("Иванов2", 200);
        map.put("Иванов3", 300);
        map.put("Иванов4", 400);
        map.put("Иванов5", 500);
        map.put("Иванов6", 600);
        map.put("Иванов7", 700);
        map.put("Иванов8", 800);
        map.put("Иванов9", 900);
        map.put("Иванов10", 1000);
       //напишите тут ваш код
        return map;
    }
    public static void removeItemFromMap(Map<String, Integer> map) {
        Map<String, Integer> copy = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair :copy.entrySet()){
            String key = pair.getKey();
            int value = pair.getValue();
            if(value<500){
                map.remove(pair.getKey());
            }
        }//напишите тут ваш код
    }
    public static void main(String[] args) {

    }
}