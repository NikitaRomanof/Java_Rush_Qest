package com.javarush.task.task19.task1914;

/* 
Решаем пример
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить на консоль решенный пример.
Вызови готовый метод printSomething(), воспользуйтесь testString.
Верни переменной System.out первоначальный поток.

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9


Требования:
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое поле testString типа TestString, которое сразу проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на экран строку "3 + 6 = ".
5. Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй PrintStream c параметром конструктора ByteArrayOutputStream).
6. Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода в консоль объекта System.out.
7. Метод main(String[] args) класса Solution должен вызывать метод printSomething(),объекта testString.
8. Метод main(String[] args) класса Solution должен модифицировать строку выведенную методом printSomething() согласно заданию, и выводить её в консоль.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream list = new ByteArrayOutputStream();
        PrintStream myOut = new PrintStream(list);
        System.setOut(myOut);
        testString.printSomething();

        String data = list.toString().replaceAll("\\D+" , " ");
        String data0 = list.toString().replaceAll("\\d+", "");
        String data1 = data0.substring(1,2);
        int x1 = Integer.parseInt(data.substring(0,data.indexOf(" ")));
        int y1 = Integer.parseInt(data.substring(data.indexOf(" ")).replaceAll(" ",""));
        System.setOut(originalOut);
        int result = 0;
        if(data1.equals("+")) {
            result = x1+y1;
        }
        else if (data1.equals("-")) {
            result = x1-y1;
        }
        else if (data1.equals("*")) {
            result = x1*y1;
        }
        System.out.println(x1 + " " + data1 + " " + y1 + " = " + result );

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

