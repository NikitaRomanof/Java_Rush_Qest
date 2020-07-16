package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;
/*
Перепись населения
Создать словарь (Map<String, String>) занести в него десять записей по принципу "Фамилия" - "Имя".
Проверить сколько людей имеют совпадающие с заданным именем или фамилией.
Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String, String состоящих из 10 записей по принципу «Фамилия» - «Имя».
4. Метод getCountTheSameFirstName() должен возвращать число людей у которых совпадает имя.
5. Метод getCountTheSameLastName() должен возвращать число людей у которых совпадает фамилия.
*/
public class Solution {
    public static Map<String, String> createMap() {
      Map<String, String> dictionary = new HashMap<String, String>();
      dictionary.put("Иваненко","Иван");
        dictionary.put("Сидоренко","Сергей");
        dictionary.put("Петров","Василий");
        dictionary.put("Пигалев","Вадим");
        dictionary.put("Иванов","Александр");
        dictionary.put("Сидоров","Александр");
        dictionary.put("Пронь","Мария");
        dictionary.put("Крамаренко","Мария");
        dictionary.put("Павлова","Светлана");
        dictionary.put("Пронько","Алена");
        return dictionary;//напишите тут ваш код
    }
    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
    int x=0;
         for(Map.Entry<String, String> pair : map.entrySet()){
         String value = pair.getValue();
         if(value.equals(name)){
             x++;
         }
         else;
     }
    return x; //напишите тут ваш код
    }
    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
      int x =0;
      for (Map.Entry<String, String> pair : map.entrySet()){
          String key = pair.getKey();
          if(key.equals(lastName)){
              x++;
          }
          else;
      }
        return x; //напишите тут ваш код
    }
    public static void main(String[] args) {
        String name1 = "Александр";
        String name2 = "Иванов";
        System.out.println(createMap());
        System.out.println(getCountTheSameFirstName(createMap(),name1));
        System.out.println(getCountTheSameLastName(createMap(),name2));


    }
}
