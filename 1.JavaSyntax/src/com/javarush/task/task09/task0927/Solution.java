package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
Есть класс кот - Cat, с полем "имя" (String).
Создать словарь Map<String, Cat> и добавить туда 10 котов в виде "Имя"-"Кот".
Получить из Map множество(Set) всех котов и вывести его на экран.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Метод createMap должен создавать новый объект HashMap<String, Cat>.
3. Метод createMap должен добавлять в словарь 10 котов в виде «Имя»-«Кот».
4. Метод createMap должен возвращать созданный словарь.
5. Метод convertMapToSet должен создать и вернуть множество котов, полученных из переданного словаря.
6. Программа должна вывести всех котов из множества на экран.
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Cat cat1 = new Cat("Bob1");
        Cat cat2 = new Cat("Bob2");
        Cat cat3 = new Cat("Bob3");
        Cat cat4 = new Cat("Bob4");
        Cat cat5 = new Cat("Bob5");
        Cat cat6 = new Cat("Bob6");
        Cat cat7 = new Cat("Bob7");
        Cat cat8 = new Cat("Bob8");
        Cat cat9 = new Cat("Bob9");
        Cat cat10 = new Cat("Bob8");
        Map<String, Cat> allCat = new HashMap<>();
        allCat.put("Bob1", cat1);
        allCat.put("Bob2", cat2);
        allCat.put("Bob3", cat3);
        allCat.put("Bob4", cat4);
        allCat.put("Bob5", cat5);
        allCat.put("Bob6", cat6);
        allCat.put("Bob7", cat7);
        allCat.put("Bob8", cat8);
        allCat.put("Bob9", cat9);
        allCat.put("Bob10", cat10);
        return allCat;//напишите тут ваш код
    }


    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> allCatSet = new HashSet<>();
        for(Map.Entry<String,Cat> pair:map.entrySet())
        {
            String key = pair.getKey();
            Cat value = pair.getValue();
            allCatSet.add(value);
        }
        return allCatSet;//напишите тут ваш код
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
