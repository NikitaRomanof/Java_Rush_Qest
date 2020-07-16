package com.javarush.task.task18.task1803;

/* 
Самые частые байты
Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

import java.awt.font.LineMetrics;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine(); // считываем путь файла
        reader.close();
        FileInputStream inputStream = new FileInputStream(fileName); // открываем ввода
        ArrayList<Integer> listByte = new ArrayList<>(); // создаем лист в который будем сохранять все байты из файла
        while(inputStream.available()>0) { // запускаем цикл до тех пор пока есть байты в потоке

            listByte.add(inputStream.read()); // непосредственно считываем байты и записываем их в лист

        }
        inputStream.close(); // закрываем поток

        Collections.sort(listByte); // сортируем лист, что бы в дальнейшем логика не нарушилась
       // System.out.println(listByte); // самопроверка какой получился лист
        int repeat = 1; // колличество повторов байтов в аррэйлисте, по умолчанию 1 т.к. каждый элемент листа как минимум 1 раз присутствует в листе )))
        Map <Integer, Integer> repeatList = new HashMap<>(); // key - это порядковый номер элемента в листе, value - это колличество повторений каждого элемента в листе
        for (int i=0; i<listByte.size()-1; i++) { // в этом цикле сравниваем текущий элемент листа со следующим и если они равны (т.е. повторяются) инкриментируем переменную
            // так как в цикле при сравнении элементов листа указывается listByte.size()-1 (потому что последний элемент не с чем сравнивать)
            if (listByte.get(i).equals(listByte.get(i + 1))) {
                repeat++;
            }
            else {
                repeat = 1; // если элемент не повторился, то переменная остается 1

            }
            repeatList.put(i+1, repeat); // i+1 тоже костыль, из-за потери одного элемента пришлось делать +1 что бы потом нулевой элемент просто создать руками
        }
        repeatList.put(0, 1); // теряется фактически 1 элемент и в качестве костыля дописали данную строку, потомучто первый элемент всегда будет повторятся 1 раз

       // System.out.println(repeatList); // снова самоконтроль, смотрим какой получилась мапа
        int maxValue = 0; // тут будет максимальное value из мапы, делать лист не нужно так как даже исли максимальных значений будет несколько, то они будут равны
        for(Map.Entry<Integer, Integer> pair: repeatList.entrySet()) { // пробегаем по мапе с помощью фо ич и ищим максимальное value
            int maxValueMap = pair.getValue();
               if(maxValueMap > maxValue) {
                maxValue = maxValueMap;
               }
        }
        // System.out.println(maxValue); // проверка смотрим максимальное количество повторений
        ArrayList<Integer> keyMaxValueMap = new ArrayList<>(); // тут лежат ключи максимальных value из мапы
        for(Map.Entry<Integer, Integer> pair: repeatList.entrySet()) { // пробегаем по мапе с помощью фо ич и сравниваем заначение value с максимальным значением value
            int key = pair.getKey();
            int value = pair.getValue();
            if (value == maxValue) {   // если value равно максимальному значению повторений, то добавлеям в keyMaxValueMap ключ этого значения
                keyMaxValueMap.add(key);
            }
        }
        // System.out.println(keyMaxValueMap); // самопроверка, тут фактически покажутся порядковый номер элемента из первого листа с максимальным колличеством повторений

        for (int x : keyMaxValueMap) { // пробегаем фо ичем, каждый элемент keyMaxValueMap используем для получения элемента из первого аррэйлиста с байтами
            System.out.print(listByte.get(x) + " "); // выводи итоговый результат, берем элемент под номером х из самого первого листа с байтами
        }

    }
}

