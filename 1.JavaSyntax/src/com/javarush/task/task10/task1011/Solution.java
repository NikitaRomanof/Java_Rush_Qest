package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
int x=-1;
       char[] z = s.toCharArray();
       for(int j=0; j<40; j++)
       {
           x++;
           for (int i = x; i < z.length; i++)
           {
               System.out.print(z[i]);
           }
           System.out.println();
       }//напишите тут ваш код
    }
}

