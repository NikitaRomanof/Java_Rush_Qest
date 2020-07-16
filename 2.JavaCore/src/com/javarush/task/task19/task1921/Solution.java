package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013


Требования:
1. Класс Solution должен содержать публичную константу PEOPLE типа List<Person>, которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
6. Программа должна правильно работать с двойными именами, например Анна-Надежда.
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        FileReader reader = new FileReader(args[0]);
        BufferedReader fileReader =  new BufferedReader(reader);
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Date> date = new ArrayList<>();
        while(fileReader.ready()) {
            String str= fileReader.readLine();
            String x = str.replaceAll("\\d","").trim();// тут отрезали все числовые значения от строки и дальше сохранили в лист, trim() обрезает лишние пробелы

            name.add(x);
            //String y = str.replaceAll("[a-zA-Z-а-яА-Я]","");// тут удалили все буквы и оставили только цифры с пробелами

            String y = str.replaceAll("\\D"," ");

            SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy", Locale.US); // указываем в каком формате принимаем дату
            Date date1 = formatter.parse(y);
            date.add(date1);

        }

        reader.close();
        fileReader.close();
        for(int i = 0; i < name.size(); i++) {
            PEOPLE.add(new Person(name.get(i), date.get(i)));
        }


    }
}
