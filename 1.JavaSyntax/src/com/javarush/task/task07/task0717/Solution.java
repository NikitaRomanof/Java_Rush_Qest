package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
Введи с клавиатуры 10 слов в список строк.
2. Метод doubleValues должен удваивать слова по принципу:
"альфа", "бета", "гамма" -> "альфа", "альфа", "бета", "бета", "гамма", "гамма"
3. Выведи результат на экран, каждое значение с новой строки.
Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Считай 10 строк с клавиатуры и добавь их в список.
3. Метод doubleValues должен удваивать элементы списка по принципу "альфа", "бета", "гамма" -> "альфа", "альфа", "бета", "бета", "гамма", "гамма".
4. Выведи получившийся список на экран, каждый элемент с новой строки.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for(int i =0; i<10; i++){
            String s = reader.readLine();
            list.add(s);
        }// Считать строки с консоли и объявить ArrayList list тут
        ArrayList<String> result = doubleValues(list);
       for(int i = 0; i<result.size(); i++){
           System.out.println(result.get(i));
       }// Вывести на экран result
    }
    public static ArrayList<String> doubleValues(ArrayList<String> list) {
       for(int i=0; i<list.size(); ){
           list.add(i+1, list.get(i));
           i = i+2;
       }           //напишите тут ваш код
        return list;
    }
}
