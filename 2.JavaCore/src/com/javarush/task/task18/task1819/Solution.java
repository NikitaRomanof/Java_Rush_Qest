package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.net.Inet4Address;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String file1Name = reader.readLine();
       String file2Name = reader.readLine();
       reader.close();
        FileInputStream file1Reader = new FileInputStream(file1Name);
        byte[] buffer1 =   new byte[file1Reader.available()];

        if (file1Reader.available() > 0) {
            file1Reader.read(buffer1);
        }

        file1Reader.close();

        FileOutputStream fileWriter = new FileOutputStream(file1Name);
        FileInputStream file2Reader = new FileInputStream(file2Name);

        byte[] buffer2 =   new byte[file2Reader.available()];
        if (file2Reader.available() > 0) {
            file2Reader.read(buffer2);
        }
        file2Reader.close();

        fileWriter.write(buffer2);
        fileWriter.write(buffer1);

        fileWriter.close();

    }
}
