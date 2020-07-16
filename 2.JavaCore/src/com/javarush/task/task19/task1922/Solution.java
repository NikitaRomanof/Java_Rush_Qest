package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
Закрыть потоки.

Пример:
words содержит слова А, Б, В

Строки:
В Б А Д //3 слова из words, не подходит
А Б А Д //3 слова из words, не подходит
Д А Д //1 слово из words, не подходит
Д А Б Д //2 слова - подходит, выводим
Д А А Д //2 слова - подходит, выводим


Требования:
1. Класс Solution должен содержать публичное статическое поле words типа List<String>, которое должно быть сразу проинициализировано.
2. Класс Solution должен содержать статический блок, в котором добавляются три или больше слов в список words.
3. Программа должна считывать имя файла с консоли (используй BufferedReader).
4. BufferedReader для считывания данных с консоли должен быть закрыт.
5. Программа должна считывать содержимое файла (используй FileReader).
6. Поток чтения из файла (FileReader) должен быть закрыт.
7. Программа должна выводить в консоль все строки из файла, которые содержат всего 2 слова из списка words.
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader fileBuffReader = new BufferedReader(fileReader);
        ArrayList<String> lines = new ArrayList<>();
        while(fileBuffReader.ready()) {
            lines.add(fileBuffReader.readLine());
        }
        fileBuffReader.close();
        fileReader.close();
        //C:\Users\Home\Desktop\firstFile.txtSystem.out.println(lines);
        for(int i = 0; i < lines.size(); i++) { // в первом цикле бьем строку ил листа на массив строк сплитуя их по пробелу
            String[] x = lines.get(i).split(" ");
            int count = 0; // счетчик, если в итоге он будет равен двум - печатаем исходную строку
                for(int j = 0; j < x.length; j++) { // во втором цикле заходим в получившейся массив
                    for(int c = 0; c < words.size(); c++) { // в третем цикле берем первую строку из получившегося массива и поочередно сранвиваем ее со словами
                        // лежащими в задоном листе, для этого поочереди перебираем заданный лист
                        if(x[j].equals(words.get(c))){
                            count++; // если есть совпадение инкрементируем счетчик
                        }
                    }
                }
             if(count==2) {
                 System.out.println(lines.get(i)); // в первом цикле, если счетчик равен 2 выводим исходную строку
             }
        }

    }
}
