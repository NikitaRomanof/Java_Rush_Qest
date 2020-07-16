package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
','=44, 's'=115, 't'=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361

Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
5. Поток для чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        byte [] buffer = new byte [fileInputStream.available()];
        fileInputStream.read(buffer);
        fileInputStream.close();
        String str1 = new String(buffer);
        char[] chars = str1.toCharArray();
        ArrayList <Character> charsList = new ArrayList<>();
        for (char x:chars) {
                charsList.add(x);
        }
        Collections.sort(charsList);

        int count= 1;
        for(int i = 0; i<charsList.size()-1; i++) {
            if(charsList.get(i)==charsList.get(i+1)) {
                count++;
            }
            else {
                System.out.println(charsList.get(i) + " " + count);
                count=1;
            }
            if(i==charsList.size()-2){
                System.out.println(charsList.get(i+1) + " " + count);
            }
        }

    }
}
