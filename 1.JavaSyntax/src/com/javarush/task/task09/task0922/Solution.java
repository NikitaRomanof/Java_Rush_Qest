package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
Ввести с клавиатуры дату в формате "2013-08-18"
Вывести на экран введенную дату в виде "AUG 18, 2013".
Воспользоваться объектом Date и SimpleDateFormat.

Требования:
1. Программа должна считывать данные с клавиатуры.
2. В программе должна быть объявлена переменная типа SimpleDateFormat.
3. В программе должна быть объявлена переменная типа Date.
4. Программа должна выводить данные на экран.
5. Вывод должен соответствовать заданию.
ЗАДАЧУ МОДИФИЦИРОВАЛ!!!!
добавил несколько вариантов изменения форматы даты
*/

public class Solution {

    public static void main(String[] args) throws Exception {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String newDate = reader.readLine();//вводим нужную дату в формате String
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US); // указываем в каком формате принимаем дату
        Date date1 = formatter.parse(newDate); // создаем переменную формата Date которая определяет дату из введенной выше переменной формата String
        formatter = new SimpleDateFormat("MMM dd, yyyy", Locale.US); // снова указываем в каком формате принимать дату
        System.out.println(formatter.format(date1).toUpperCase());// выводим в консоль дату принятую из String в новом формате
                                                                    //.toUpperCase() для того что бы изменить регистр названия месяца
        // этот кусок кода я добавил для примера, что бы отразить что можно вообще самостоятельно задать формат вывода даты
        // для этого нужно создать новый объект DateFormatSymbols() к которому переопределить метод getMonths() задав по своему название месяцев
        formatter = new SimpleDateFormat("dd MMMM", myDateFormatSymbols );
        System.out.println("Constructor 3: " + formatter.format( date1 ) );
    }
    private static DateFormatSymbols myDateFormatSymbols = new DateFormatSymbols(){

        @Override
        public String[] getMonths() {
            return new String[]{"января", "февраля", "марта", "апреля", "мая", "июня",
                    "июля", "AUG", "сентября", "октября", "ноября", "декабря"};
        }

    };
}

