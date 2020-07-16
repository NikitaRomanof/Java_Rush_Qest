package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла.
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines.
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines.
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.


Требования:
1. Класс Solution должен содержать public static поле allLines типа List<String>.
2. Класс Solution должен содержать public static поле forRemoveLines типа List<String>.
3. Класс Solution должен содержать public void метод joinData() который может бросать исключение CorruptedDataException.
4. Программа должна считывать c консоли имена двух файлов.
5. Программа должна считывать построчно данные из первого файла в список allLines.
6. Программа должна считывать построчно данные из второго файла в список forRemoveLines.
7. Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines, если в allLines содержаться все строки из списка forRemoveLines.
8. Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException, если в allLines не содержаться все строки из списка forRemoveLines.
9. Метод joinData должен вызываться в main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    static
    {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));// здесь открываем ридер с буфером чтобы ввести
            // пути файлов в консоль
            String firstFileName = reader.readLine();// вводим имя первого файла
            String secondFileName= reader.readLine();// вводим имя второго файла
            reader.close(); // обязательно закрываем ридер!
            BufferedReader fileRead = new BufferedReader(new InputStreamReader(new FileInputStream(firstFileName)));
            while(fileRead.ready()){
                allLines.add(fileRead.readLine());
            }

            fileRead = new BufferedReader(new InputStreamReader(new FileInputStream(secondFileName)));
            while(fileRead.ready()){
                forRemoveLines.add(fileRead.readLine());
            }
            fileRead.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        Solution start = new Solution(); // создаем экземпляр класса, в котором прописана вся логика считывания пути файлов и содержания самих файлов
        start.joinData(); // запускаем наш метод с экземпляром класса

    }

    public void joinData() throws CorruptedDataException, IOException    {
        if (allLines.containsAll(forRemoveLines)) { // проверяем на то содержится ли весь лист в forRemoveLines в листе allLines
            allLines.removeAll(forRemoveLines); // если да, то все содержащееся в листе forRemoveLines удаляем из листа allLines
        }
        else {
            allLines.clear(); // если нет, то очищаем весь лист allLines
            throw new CorruptedDataException();
        }

       }

    }

