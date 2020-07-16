package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1 = new FileInputStream(reader.readLine());
        FileOutputStream file2 = new FileOutputStream(reader.readLine());
        reader.close();
        int count = file1.available();
        byte[] buffer = new byte[count];
        file1.read(buffer);
        for (int i = buffer.length - 1; i >= 0 ; i--) {
            file2.write(buffer[i]);
        }
        file1.close();
        file2.close();

    }

}

