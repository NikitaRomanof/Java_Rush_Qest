package com.javarush.task.task18.task1808;

/* 
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException, ArithmeticException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream2 = new FileOutputStream(reader.readLine());
        FileOutputStream outputStream3 = new FileOutputStream(reader.readLine());
        reader.close();
        /*
        второй вариант решения этой задачи без списков.
        вводим три переменных, которые регулируют длингы массивов*/
       int count =  inputStream.available(); // это колличество всех не прочитанных байт в файле
       int a = (count/2)+(count%2); // это первая половина не прочитанных байт (если четное число, то будут ровно пополам)
        // если число не четное то тут будет больше
       int b = count - a; // это второя (меньшая) половина не прочитанных байт
       byte [] buffer2= new byte [a]; // создаем буфер для чтения первой половины байт уже определенным числом
       byte [] buffer3= new byte[b]; // аналогично для второй половины

        inputStream.read(buffer2); // читаем первую половину байт (большую если общее колличество байт нечетное число)
        outputStream2.write(buffer2); // записываем прочитанное колличество байт из первой половины файла
        inputStream.read(buffer3); // читаем вторую половину байт из файла (меньшую, если число нечетное)
        outputStream3.write(buffer3); // записываем вторую половину прочитанных байт из файла
        inputStream.close();
        outputStream2.close();
        outputStream3.close(); // закрываем все потоки ввода и вывода
    }
}
