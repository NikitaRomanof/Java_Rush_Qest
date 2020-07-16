package com.javarush.task.task19.task1925;

/* 
Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать через запятую во второй файл все слова из первого файла длина которых строго больше 6(используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(args[0]);
        BufferedReader buffReader = new BufferedReader(reader);
        ArrayList<String> allStrings = new ArrayList<>();
        while(buffReader.ready()){
            allStrings.add(buffReader.readLine());// добавили всё из файла в лист
        }
        buffReader.close();
        reader.close();
        FileWriter writer = new FileWriter(args[1]);
        StringBuilder str = new StringBuilder(); // в эту строку будем перезаписывать все нужные слова через запятую
        for(int i = 0; i < allStrings.size(); i++) { //  в первом цикле перебираем лист, первый элемент листа разбиваем сплитом на массив строк по пробелу
            String[] words = allStrings.get(i).split(" ");
                for(int j = 0; j < words.length; j++) { // во втором цикле берем каждый элемент получившегося массива строк и проверяем его длину
                    String z = words[j];
                    if(z.length()>6){ // если длина больше 6, то
                        str.append(z).append(","); //  сохраняем слова в строку через StringBuilder
                    }
                }
        }

        String lastString = str.substring(0,str.lastIndexOf(","));
        writer.write(lastString);
        writer.close();


    }
}
