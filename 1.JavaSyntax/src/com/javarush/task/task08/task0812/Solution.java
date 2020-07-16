package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
Cамая длинная последовательность
1. Создай список чисел.
2. Добавь в список 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.
Пример для списка 2, 4, 4, 4, 8, 8, 4, 12, 12, 14:
3
Искомое значение равно 3, т.к. самая длинная последовательность повторяющихся чисел состоит из трех четверок.
Требования:
1. Программа должна выводить число на экран.
2. Программа должна считывать значения с клавиатуры.
3. В методе main объяви переменную типа List с типом элементов Integer и сразу проинициализируй ee.
4. Программа должна добавлять в коллекцию 10 чисел, согласно условию.
5. Программа должна выводить на экран длину самой длинной последовательности повторяющихся чисел в списке.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<Integer>();
              for(int i=0; i<10; i++){
           list.add(i, Integer.parseInt(reader.readLine()));
       }
       int z =1;
       ArrayList<Integer> list2 = new ArrayList<>();
       for(int i =0; i<list.size() - 1; i++){
          if(list.get(i).equals(list.get(i + 1))){
            list2.add(z++);
          }
          else
              z =1;
           list2.add(z);
       }
       int max=0;
       for(int j=0; j<list2.size(); j++){
           if(list2.get(j)> max){
               max = list2.get(j);
           }
       }
        System.out.print(max);//напишите тут ваш код
    }
}