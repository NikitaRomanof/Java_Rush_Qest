package com.javarush.task.task18.task1818;

/* 
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream file1Writer = new FileOutputStream(reader.readLine(),true);
        FileInputStream file2Reader = new FileInputStream(reader.readLine());
        FileInputStream file3Reader = new FileInputStream(reader.readLine());

        reader.close();
        while (file2Reader.available()>0) {
            int data = file2Reader.read();
            file1Writer.write(data);
        }
        file2Reader.close();

        while (file3Reader.available()>0) {
            int data = file3Reader.read();
            file1Writer.write(data);
        }
        file3Reader.close();
        file1Writer.close();



    }
}
