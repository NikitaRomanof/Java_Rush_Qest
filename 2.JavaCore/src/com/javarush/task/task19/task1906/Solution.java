package com.javarush.task.task19.task1906;

/* 
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).

Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна записывать во второй файл все байты из первого файла с четным порядковым номером (используй FileWriter).
6. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1Name= reader.readLine();
        String file2Name = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(file1Name);
        ArrayList<Character> charList = new ArrayList<>();
        while (fileReader.ready()) {
            int x = fileReader.read();
            charList.add((char) x);
        }
        fileReader.close();
        FileWriter fileWriter = new FileWriter(file2Name);
        for(int i =1; i<charList.size(); i++) {
            if(i%2!=0) { // вся соль задачи тут, отсчет в листе начинается с нуля, а нам нужны четные порядковые символы
                // т.е. получается 0 - нечетный, а 1 символ - уже четный )))
                fileWriter.write(charList.get(i));
            }

        }
        fileWriter.close();

    }
}
