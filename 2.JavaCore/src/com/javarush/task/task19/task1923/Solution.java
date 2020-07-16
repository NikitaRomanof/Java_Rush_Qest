package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенными пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(args[0]);
        BufferedReader buffReader = new BufferedReader(reader);
        FileWriter writer = new FileWriter(args[1]);

        String str;
        while((str=buffReader.readLine())!=null){
           String[] s = str.split(" ");
            for(int i = 0; i<s.length; i++) {
                String x = s[i].replaceAll("\\D","");
                if(!x.contentEquals("")) {
                    writer.write(s[i]+" ");


                }

            }

        }
        reader.close();
        buffReader.close();
        writer.close();

    }
}
