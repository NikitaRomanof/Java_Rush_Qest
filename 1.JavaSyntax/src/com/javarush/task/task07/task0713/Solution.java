package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число нацело делится на 3 (x%3==0), нацело делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
Порядок объявления списков очень важен.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.


Требования:
1. Объяви и сразу проинициализируй 4 переменных типа ArrayList<Integer> (список целых чисел). Первый список будет главным, а остальные - дополнительными.
2. Считать 20 чисел с клавиатуры и добавить их в главный список.
3. Добавить в первый дополнительный список все числа из главного, которые нацело делятся на 3.
4. Добавить во второй дополнительный список все числа из главного, которые нацело делятся на 2.
5. Добавить в третий дополнительный список все остальные числа из главного.
6. Метод printList должен выводить на экран все элементы переданного списка, каждый с новой строки.
7. Программа должна вывести три дополнительных списка, используя метод printList.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      ArrayList<Integer> int1 = new ArrayList<Integer>();
      ArrayList<Integer> int3 = new ArrayList<Integer>();
      ArrayList<Integer> int2 = new ArrayList<Integer>();
      ArrayList<Integer> int0 = new ArrayList<Integer>();
      for(int i = 0; i<20; i++){
          int z = Integer.parseInt(reader.readLine());
          int1.add(i, z);
      }
      for(int i = 0; i<int1.size(); i++){
          if(int1.get(i)%3==0 || int1.get(i)%3==0 && int1.get(i)%2==0 ){
              int3.add(int1.get(i));
          }
          if (int1.get(i)%2==0 || int1.get(i)%2==0 && int1.get(i)%3==0){
              int2.add(int1.get(i));
          }
          if (int1.get(i)%3!=0 && int1.get(i)%2!=0){
              int0.add(int1.get(i));
          }
      }
      printList(int3);
      printList(int2);
      printList(int0);//напишите тут ваш код
    }
    public static void printList(ArrayList<Integer> list) {
        for(int i=0; i< list.size(); i++){
            System.out.println(list.get(i));
        }//напишите тут ваш код
    }
}
