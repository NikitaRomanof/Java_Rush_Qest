package com.javarush.task.task08.task0817;

import java.util.*;
/*
Нам повторы не нужны
Создать словарь (Map<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
Удалить людей, имеющих одинаковые имена.
Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String, String состоящих из 10 записей.
4. Метод removeTheFirstNameDuplicates() должен удалять из словаря всех людей, имеющие одинаковые имена.
5. Метод removeTheFirstNameDuplicates() должен вызывать метод removeItemFromMapByValue().
*/
public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<String, String>(); // создаем исходную Мапу
        map.put("Иванов","Саня");
        map.put("Петров","Ваня");
        map.put("Сидоров","Дима");
        map.put("Васьльев","Саня");
        map.put("Сергеев","Ваня");
        map.put("Иванова","Маша");
        map.put("Петрова","Даша");
        map.put("Сидорова","Оля");
        map.put("Васильева","Аня");
        map.put("Сергеева","Оля");
        return map;   //напишите тут ваш код
          }
    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
       Map<String, String> copy2 = new HashMap<>(map); // создаем копию исходной Мапы, так как в Мапе одновременно считывать значения и удалять нельзя
        Set<String> set = new HashSet<>(map.values()); // создаем Set, фишка в том, что данная коллекция может хранить только уникальные значения
        Iterator<String> iterator = set.iterator();
       for(int i =0; i<set.size();i++){
           String text = iterator.next();
           for(int j = i+1; j<set.size();j++){
               if(text.equals(copy2.values())){
                   removeItemFromMapByValue(map,text);
               }
           }
       }


       // Iterator<Map.Entry<String, String>> iterator = copy2.entrySet().iterator(); // создаем итератор для копии исходной Мапы
       // for(String name: copy2.values() ){ // запускаем фор ич для по КОПИИ Мапы(ВАЖНО) (создаем перменную типа String  которой присваиваем по очереди значение value КОПИИ Мапы)
          //  if (!set.add(name)) { // Вот еще фишка, Set может содержать только уникальные значения, когда мы начинаем записывать значения String в Set записываются уникальные значения,
                                   // данная строка дословно значит  "если добавление в Set пременной name будет false то вызываем нижний метод"
             //   removeItemFromMapByValue(map, name); // а если значение не уникальное и уже содержится в Set, то вызываем нижний метод к ОСНОВНОЙ Мапе(Важно) и name(Важно)
           // }                                        // нижний метод удаляет ячеку основной Мапы от name
      //  }
       System.out.print(map.values());

        }
    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map); // создаем Копию основной Мапы
        for (Map.Entry<String, String> pair : copy.entrySet()) { // запускаем фо ич с переменной pair по значениям копии Мапы
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey()); // удаляем ячейку по значению ключа основной Мапы
            }
        }
            }
    public static void main(String[] args) {
        removeTheFirstNameDuplicates(createMap());
    }
}
