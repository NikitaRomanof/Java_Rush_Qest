package com.javarush.task.task19.task1907;

/* 
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileName);
        char[] chars = new char[2000]; // создаем массив чаров (вот тут большой вопрос какой длины создавать массив?)
        fileReader.read(chars); // читаем в этот массив чары
        fileReader.close();

        String x =  new String(chars); // делаем из массива чаров строку, но в этой строке могут быть различные символы кроме слов

        String y =x.replaceAll("\\W+"," "); // регулярка которая оставляет только слова с разделителем пробелом


        String[] words = y.split(" "); // разделяем полученную строку из слов на отдельные слова и складываем их в массив
        int count = 0;
        for (int i = 0 ; i< words.length; i++){
            if(words[i].equalsIgnoreCase("world")) { // сравниваем каждое слово в массиве с требуемым словом без учета регистра
                count++;
            }

        }
        System.out.println(count);






    }
}
