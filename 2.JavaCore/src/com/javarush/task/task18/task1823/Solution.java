package com.javarush.task.task18.task1823;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

/* 
Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.
*/

public class Solution {
    private static final String GREETINGS_MESSAGE = "My name is %s, my age is %d!";

    public static void main(String[] args) throws IOException {

        PrintStream printStream = new PrintStream("C:\\Users\\Home\\Desktop\\firstFile.txt");

        printStream.println("Hello!");
        printStream.println("We are robots!");

        printStream.printf(GREETINGS_MESSAGE, "Amigo", 18);
        printStream.printf(GREETINGS_MESSAGE, "R2-D2", 35);
        printStream.printf(GREETINGS_MESSAGE, "C-3PO", 35);

        printStream.close();
    }
}
