package com.javarush.task.task14.task1420;

/* 
НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.


Требования:
1. Программа должна считывать с клавиатуры 2 строки.
2. В случае если введенные строки невозможно преобразовать в положительные целые числа, должно возникать исключение.
3. Программа должна выводить данные на экран.
4. Программа должна выводить на экран наибольший общий делитель(НОД) чисел считанных с клавиатуры и успешно завершаться.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int x = Integer.parseInt(reader.readLine());
            int y = Integer.parseInt(reader.readLine());
        if (x <= 0 || y <= 0) throw new Exception();
            Divide(x,y);

    }
    public static void Divide(int a, int b) {//start of your method
        int temp;
        // making a greater than b
        if (b > a) {
            temp = a;
            a = b;
            b = temp;
        }
        while (b !=0) {
            // gcd of b and a%b
            temp = a%b;
            // always make a greater than b
            a = b;
            b = temp;
        }
        System.out.println(a);//print to console
    }
}
