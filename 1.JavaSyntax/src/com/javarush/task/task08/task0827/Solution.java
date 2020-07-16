package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
/*
Работа с датой
Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате FEBRUARY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
Требования:
1. Программа должна выводить текст на экран.
2. Класс Solution должен содержать два метода.
3. Метод isDateOdd() должен возвращать true, если количество дней с начала года - нечетное число, иначе false.
4. Метод main() должен вызывать метод isDateOdd().
************************************************************
Мой комментарий. В гугле посмотрел как перевести тип стринг в тип дата. Сперва перевили заданную дату из стринг в дэйт,
потом из заданной даты выдернули дни
*/
public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("JANUARY 1 2000"));
    }
    public static boolean isDateOdd(String date) throws ParseException {
        Date thisDate = new Date(date); // на удивление сработало, т.е. объект класса сам понимает подобную строку и парсит ее без нашего вмешательства
        Date yearBegin = new Date(date); // далее я создал еще один объект Date и вогнал в него 1 января через геттеры.

        long days = (thisDate.getTime() - yearBegin.getTime());
        long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках

        int dayCount = (int) (days/msDay); //количество целых дней

        if(dayCount%2==0){
            return false;
        }


         return  true;
    }
}
