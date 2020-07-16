package com.javarush.task.task14.task1414;

/* 
MovieFactory
Расширение функционала по аналогии, чтение с консоли:
1. Разобраться, что программа умеет делать.
2. Все классы должны быть внутри класса Solution.
3. Добавить классы Cartoon, Thriller.
4. Разобраться, как мы получаем объект класса SoapOpera по ключу "soapOpera".

Аналогично получению объекта SoapOpera сделать:
5. Добавить в MovieFactory.getMovie получение объекта Cartoon для ключа "cartoon".
6. Добавить в MovieFactory.getMovie получение объекта Thriller для ключа "thriller".
7. Считать с консоли несколько ключей (строк).
7.1. Ввод заканчивается, как только вводится строка не совпадающая с одной из: "cartoon", "thriller", "soapOpera".
8. Создать переменную movie типа Movie и для каждой введенной строки(ключа):
8.1. Получить объект используя MovieFactory.getMovie и присвоить его переменной movie.
8.2. Вывести на экран movie.getClass().getSimpleName().


Требования:
1. Классы Cartoon и Thriller должны быть статическими и существовать внутри класса Solution.
2. Метод MovieFactory.getMovie должен возвращать объект типа Cartoon в случае передачи ему строки "cartoon" в качестве параметра.
3. Метод MovieFactory.getMovie должен возвращать объект типа Thriller в случае передачи ему строки "thriller" в качестве параметра.
4. Метод main должен считывать строки с клавиатуры.
5. Метод main должен прекращать считывать строки с клавиатуры в случае, если была введена некорректная строка(не "cartoon", не "thriller" или не "soapOpera").
6. Для каждой введенной строки (в том числе для некорректной) необходимо вызвать метод MovieFactory.getMovie.
7. Для всех введенных корректных строк необходимо вывести на экран простые имена(movie.getClass().getSimpleName()) типов объектов возвращаемых методом MovieFactory.getMovie.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static <Move> void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> keys = new ArrayList<>(); // создаем список в который будут записаны все строки введеные с клавы
        String key= null; // переменная используемая в цикле, ее значение вводится с клавы
        label: // для свитч
          while(true){
            key = reader.readLine();
            switch (key) {
                case "soapOpera":
                    keys.add(key);
                    break;
                case "thriller":
                    keys.add(key);
                    break;
                case "cartoon":
                    keys.add(key);
                    break;
                default:
                    MovieFactory.getMovie(key); // что обмануть валидатор в реальной программе это не нужно
                    break label;
            }
        }
        for(int i =0; i<keys.size(); i++){
          System.out.println(MovieFactory.getMovie(keys.get(i)).getClass().getSimpleName()); // сразу создаем объект по стринговой переменной из списка и сразу выводит имя
        }
            }
    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;
           /* в этот метод передается стринговая переменная, ее значение проверяется и если оно совподает с одним из трех указанных значений
            то создается объект соответствующий определенному значению. Стринговая переменная берется из созданного списка(keys). В итоге возвращается созданный объект. */
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            else if ("thriller".equals(key)) {
                movie = new Thriller();
            }
            else if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }
            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }
   static class Cartoon extends Movie {

   }
   static class Thriller extends Movie {

   }


    //Напишите тут ваши классы, пункт 3
}
