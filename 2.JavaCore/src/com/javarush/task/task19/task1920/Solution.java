package com.javarush.task.task19.task1920;

/* 
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        FileReader fileReader = new FileReader(fileName);
        BufferedReader fileBuffRead = new BufferedReader(fileReader);
        ArrayList<String> lastName = new ArrayList<>();
        ArrayList<Double> money = new ArrayList<>();
        while(fileBuffRead.ready()) {
            String str = fileBuffRead.readLine();
            String str1 = str.substring(0, str.indexOf(" ")); // тут сабстрингом отрезали по пробелу фамилию человека
           double x = Double.parseDouble(str.substring(str.lastIndexOf(" ")));// тут сабстрингом отрезали по пробелу число - double
            lastName.add(str1);
            money.add(x); // тут все добавили в листы в одном порядке
        }
        fileBuffRead.close();
        fileReader.close();
        //System.out.println(lastName); // проверка
        //System.out.println(money); // проверка
        TreeMap<String, Double> person = new TreeMap<>();
        for(int i = 0; i < lastName.size(); i++) {
            person.merge(lastName.get(i), money.get(i), (a, b) -> a +b); // тут использовал метод merge() он проверяет на наличие кей в мапе и если есть, добавлейт видоизмененную валуе
        }
        //System.out.println(person); // проверка
        TreeSet<String> finalPerson = new TreeSet<>();
                double y = Double.NEGATIVE_INFINITY;
        for(Map.Entry<String, Double> pair : person.entrySet() ) { // в этом цикле мы ищем максимальное значение
            String strPerson = pair.getKey();
            double z = pair.getValue();
            if(z>=y) {
                y = z;
            }
        }
        for(Map.Entry<String, Double> pair : person.entrySet() ) { // а тут уже по максимальному значению добавляем все в лист
            String strPerson = pair.getKey();
            double z = pair.getValue();
            if(z>=y) {
                finalPerson.add(strPerson);
            }
        }
        finalPerson.forEach(s -> System.out.println(s)); // это метод заменяет цикл фо ич
    }
}
