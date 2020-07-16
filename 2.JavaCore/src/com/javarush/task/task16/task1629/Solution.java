package com.javarush.task.task16.task1629;
/*
Только по-очереди!
1. В классе Solution создать public static класс нити Read3Strings унаследовавшись от Thread.
2. В методе run реализовать чтение с консоли трех строк.
3. Три подряд введенных строки должны считываться в одной нити и объединяться в одну строку через пробел.
4. В методе main вывести результат для каждой нити.
5. Используй join.

Пример:

Входные данные:
a
b
c
d
e
f

Выходные данные:
a b c
d e f


Требования:
1. Объяви в классе Solution public static класс Read3Strings.
2. Класс Read3Strings должен быть унаследован от Thread.
3. Метод run класса Read3Strings должен считывать три строки.
4. Класс Read3Strings должен содержать публичный метод printResult.
5. Метод printResult должен выводить в консоль 3 считанные строки, разделив их пробелами.
6. Метод main должен вызывать методы start у созданных нитей.
7. Метод main должен вызывать методы join у созданных нитей.
8. Вывод программы должен отображать, что потоки считывали строки последовательно, а не параллельно.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
// reader сразу запустили в солюшене поэтопу в Read3Strings классе новый ридер делать не нужно
    public static void main(String[] args) throws InterruptedException, IOException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
// создали два трэда, причем пока их не запускаем, так как по условию они должны работать последовательно
        t1.start(); // запускаем первый трэд
        t1.join(); // тормазим main пока первый трэд не считает все что нам нужно

        t2.start(); // запускаем второй трэд
        t2.join(); // опять тормозим main, что бы второй трэд считал все что нужно
        t1.printResult(); // печатыем считанное первым трэдом
        t2.printResult(); // печатаем считанное вторым трэдом
       reader.close(); // обязательно зарываем reader
        //add your code here - добавьте код тут

    }

    public static class Read3Strings extends Thread {
        public ArrayList <String> results = new ArrayList<>(); // что бы программа была универсальной создаем аррэй лист
        // все считанные строки трэдом будим сохранять в нем
        @Override
        public void run() {
                       for(int i = 0; i<3;i++){ // считываем три строки (по условию) и сразу сохраняем их в аррэй лист
                try {
                        results.add(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        public void printResult(){
            for(String result : results){ // просто распечатываем аррэй лист в той последовательности в какой просят в условии
                System.out.print(result + " ");
            }
            System.out.println();
        }
    }
}
