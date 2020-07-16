package com.javarush.task.task18.task1801;

/* 
Максимальный байт
Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться максимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(fileName);
        int maxByte = Integer.MIN_VALUE;
        ArrayList<Integer> allByte = new ArrayList<>();
        while(inputStream.available()>0){
            allByte.add(inputStream.read());


        }
        inputStream.close();
        for(int min:allByte){
            if(min>maxByte){
                maxByte = min;
            }
        }
        System.out.println(maxByte);
    }
}
