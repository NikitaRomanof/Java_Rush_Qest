package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел).
Слова вывести в возрастающем порядке, числа - в убывающем.

Пример ввода:
Вишня
1
Боб
3
Яблоко
22
0
Арбуз

Пример вывода:
Арбуз
22
Боб
3
Вишня
1
0
Яблоко


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить данные на экран.
3. Выведенные слова должны быть упорядочены по возрастанию (используй готовый метод isGreaterThan).
4. Выведенные числа должны быть упорядочены по убыванию.
5. Метод main должен использовать метод sort.
6. Метод sort должен использовать метод isGreaterThan.
7. Метод sort должен использовать метод isNumber.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);
    }

    public static void sort(String[] array) {
        ArrayList<String > strings = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        for(int i = 0; i<array.length; i++){
            if(!isNumber(array[i])){
                strings.add(array[i]);
            }
            else integers.add(Integer.parseInt(array[i]));
        }
        Integer[] array2 = integers.toArray(new Integer[0]);
        for(int i =0; i<array2.length; i++){
            for(int j=i+1; j<array2.length-1; j++ ){
                if(array2[i]<array2[j]){
                    int a = array2[i];
                    array2[i] = array2[j];
                    array2[j] = a;
                }
            }
        }
        for(int i =0; i<array2.length; i++)
        {
            System.out.println(array2[i]);
        }
        String[] array3 = strings.toArray(new String[0]);
        for (int i =0; i<array3.length; i++) {
            for (int j=i+1; j<array3.length-1; j++ ) {
                if(isGreaterThan(array3[j], array3[i])){
                    String s = array3[j];
                    array3[j] = array3[i];
                    array3[i]= s;
                }
            }
        }

        for(int i =0; i<array3.length; i++)
        {
            System.out.println(array3[i]);
        }
        // напишите тут ваш код
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
