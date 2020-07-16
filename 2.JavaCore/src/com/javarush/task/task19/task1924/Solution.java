package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно.
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла, считать содержимое файла.
3. Заменить все числа на слова используя словарь map.
4. Результат вывести на экран.
5. Закрыть потоки.

Пример данных в файле:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода в консоль:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.


Требования:
1. Класс Solution должен содержать публичное статическое поле map типа Map<Integer, String>, которое должно быть сразу проинициализировано.
2. Программа должна считывать имя файла с консоли (используй BufferedReader).
3. BufferedReader для считывания данных с консоли должен быть закрыт.
4. Программа должна считывать содержимое файла (используй FileReader).
5. Поток чтения из файла (FileReader) должен быть закрыт.
6. Программа должна выводить в консоль все строки из файла, но числа должны быть заменены на слова из словаря map.
7. Класс Solution должен содержать статический блок, в котором добавляются в map тринадцать пар.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static
    {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");

    }

    public static void main(String[] args) throws IOException {
        String fileName;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<String> allStrings = new ArrayList<>();

        while (bufferedReader.ready()) {
            allStrings.add(bufferedReader.readLine());
        }
        bufferedReader.close();
        fileReader.close();

        for(int i = 0; i < allStrings.size(); i++) { // в первом цикле бьем строку из листа на массив слов по пробелу
           String[] allWords = allStrings.get(i).split(" ");
           String z = ""; // в эту строку будем записывать все слова из массива через пробел (и измененные слова и нет)
                for(int j = 0; j < allWords.length; j++) { // во втором цикле берем каждое слово и в try-cath пытаемся его спарсить до числа
                    int x = -1;

                    try{
                        //System.out.println("исходное слово в массиве: " + allWords[j]);
                        x = Integer.parseInt(allWords[j]);
                        if(x>=0 && x<=12) { // если спарсить получится, и полученное число попадает в нужный нам диапазон чисел
                            allWords[j] = map.get(x); // полученное число - ключ из мапы, по ключу берем значение и перезаписываем строку на полученное значение
                           // System.out.println("измененное слово в массиве: " + allWords[j]);



                        }
                    }
                    catch(Exception e){
                        //System.out.println("слово не число, пробуем парсить дальше");
                    }
                    finally {
                        z = z+allWords[j]+" "; // тут сохраняем все слова из массива в строку и не забываем про пробел
                    }


                }
            System.out.println(z); // выводим в консоль полученную строку

        }




    }
}
