package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream originalOut = System.out; // сохранили оригинальный System.out
        ByteArrayOutputStream list = new ByteArrayOutputStream();// создали лист спаренный с OutputStream

        PrintStream myPrint = new PrintStream(list); //создали новый поток PrintStream и впихнули в его констрктор наш лист(тут важно понимать, что не любой лист сюда войдет)
        // войдут только классы связанныфе с OutputStream, иначе не будут полученны данные
        System.setOut(myPrint); // заминили оригинальный System.out на наш модифицированый
        testString.printSomething(); // вызвали метод печатания на экран, он кстати ничего не будет печатать (хотя можно сделать реализацию. что бы печатал и еще что-то делал)
        String data = list.toString().toUpperCase(); // тут наш Лист привели к строке и поменяли регистр букв (как просит условие);
        System.setOut(originalOut); // вернули оригинальный System.out
        System.out.println(data); // распечатали инфу полученную в Лист и  слегка модифицированную



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
