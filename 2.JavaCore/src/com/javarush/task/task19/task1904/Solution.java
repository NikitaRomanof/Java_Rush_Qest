package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
В классе адаптере создать приватное финальное поле Scanner fileScanner. Поле инициализировать в конструкторе с одним аргументом типа Scanner.

Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1957

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные только одного человека.


Требования:
1. PersonScanner должен быть интерфейсом.
2. Класс PersonScannerAdapter должен реализовывать интерфейс PersonScanner.
3. Класс PersonScannerAdapter должен содержать приватное поле fileScanner типа Scanner.
4. Класс PersonScannerAdapter должен содержать конструктор с параметром Scanner.
5. Метод close() класса PersonScannerAdapter должен делегировать полномочие такому же методу fileScanner.
6. Метод read() класса PersonScannerAdapter должен читать строку с файла, парсить её, и возвращать данные только одного человека, в виде объекта класса Person.
*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args)  {


    }

    public static class PersonScannerAdapter implements PersonScanner { // создаем классический адаптер, импелементирую интерфейст
        private final Scanner fileScanner; // и назнаячая приватное поле адаптируемого класса
        public PersonScannerAdapter (Scanner fileScanner) { // создаем конструктор
            this.fileScanner = fileScanner;
        }
        // далее переопределяем методы интерфейса, вернее реализуем их через адаптируемы класс
        @Override
        public Person read() throws IOException, ParseException {
            // тут вся логика задачи, считываем сканер строку, разбиваем ее до нужного вида, парсим дату,
            // и все это пихаем в конструктор Person  при создании new Person
            String line =  fileScanner.nextLine();
            String toTransf = line.substring(line.indexOf(" ")+1);
            String toTransf2 = toTransf.substring(toTransf.indexOf(" ")+1);
            String firstName = toTransf.substring(0,toTransf.indexOf(" ")); ; // имя
            String middleName = toTransf2.substring(0,toTransf2.indexOf(" "));; // типо отчество
            String lastName = line.substring(0,line.indexOf(" "));; // фамилия
            String birthDate = toTransf2.substring(toTransf2.indexOf(" ")+1);
            SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
            Date date = formatter.parse(birthDate);
            Person x = new Person(firstName,middleName,lastName,date);

             return x;


        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
