package com.javarush.task.task18.task1820;

/* 
Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.
Моя реализация, работает для любого файла, не только файла в одну строчку или столбик
*/

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String fileName1 = reader.readLine();
       String fileName2 = reader.readLine();
       reader.close();
        BufferedReader fileRead = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1))); // тут октрыли буфер чтения из файла сразу строками
        FileOutputStream filWriter = new FileOutputStream(fileName2); // отклыри врайтер. обычный не баффер
        ArrayList<String[]> numbersString = new ArrayList<>(); // создали лист из массивов стринговый, сюда будем записывать каждую строку файла
        // лист из массивов, потому что сразу сплитуем входящую из файла строку и записываем массив строк
        // если бы в файле была только одна строка то можно было бы сделать просто массив строк без листа, но это не интересно
        ArrayList<Double> numbers = new ArrayList<>(); // сюда будем записывать распарсенные double
        String line; // это строка для чтения из файла, создал переменную, что бы не нагромаждать код


        while(fileRead.ready()) {
            line = fileRead.readLine(); // считываем строку из файла
            numbersString.add(line.split(" ")); // сразу сплитуем считанную строку и сохраняем массив в лист

        }
        fileRead.close(); // закрываем ридер
        int countLineInFile = 0; // счетчик который отслеживает сколько чисел в каждой строке (такая реализацмя работает корректно, если в листе массивов длина всех массивов равна)

        for(int i =0 ; i<numbersString.size(); i++) { // первый цикл пробегает по всем элементам листа
            String[] numbersBuffer = numbersString.get(i); // каждый элемент листа состоит из массивов, поэтому создаем массив из элемента листа
            for(int j = 0; j<numbersBuffer.length; j++) { // пробегаем по созданному массиву из элемента листа
                numbers.add(Double.parseDouble(numbersBuffer[j])); // парсим в double каждый элемент массива и сохраняем в другой лист
                countLineInFile = numbersBuffer.length;
            }
        }
        //System.out.println(numbers); // проверяем что получилось

        int count = 0; // счетчик для проставления интеров в файл
        for(int i = 0; i<numbers.size(); i++) { // прошлись по всем элементам double листа, округлили как нам нужно при помощи  BigDecimal по условию и сохранили в новый файл через пробел
            double z = numbers.get(i);
            BigDecimal result = new BigDecimal(z);
            if(z>0){
                result = result.setScale(0, RoundingMode.HALF_UP);
            }
            else {
                result = result.setScale(0, RoundingMode.HALF_DOWN);
            }

            String q = String.valueOf(result); // тут округленный бигДесимал преобразуем в строку
            byte[] data = q.getBytes(); // полученную строку преобразуем в массив байт
            //System.out.println(q);

            filWriter.write(data); // тут будет записываться байт код нужного нам округленного числа (массив байт выше)
            filWriter.write(32); // тут символ пробела между числами
            count++;
            if(count==countLineInFile) { // если счетчик сравнялся с колличеством чисел в массиве (элементе первого листа) ставим интер в новом файле
                filWriter.write(13); // тут символ интера
                count=0; // и обнуляем счтчик

            }
        }
        filWriter.close();
    }
}
