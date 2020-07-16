package com.javarush.task.task10.task1012;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 маленьких букв алфавита). Результат вывести на экран в алфавитном порядке.

Пример вывода:
а 5
б 8
в 3
г 7
д 0
...
я 9


Требования:
1. Программа должна 10 раз считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. Выведенный текст должен содержать 33 строки.
4. Каждая строка вывода должна содержать букву русского алфавита, пробел и сколько раз буква встречалась в введенных строках.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а','б','в','г','д','е','ё','ж',
                'з','и','й','к','л','м','н','о',
                'п','р','с','т','у','ф','х','ц',
                'ч','ш','щ','ъ','ы','ь','э','ю','я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
       ArrayList<Object> itog = new ArrayList<>(); // создаем новый аррэйлист что бы в него впихнуть потолм все буквы из строк
        for(int i=0; i<list.size(); i++)
        {
            char[] z = list.get(i).toCharArray(); // из аррэй листа со строками формируем массив с чарами, последовательно, т.е. одна строка <=> один массивов чар
            for(int j=0; j<z.length; j++)
            {
                for(int k=0; k<alphabet.size(); k++){
                    if(alphabet.get(k)==z[j] ) // все массивы чаров впихиваем в один аррэйлист чаров, тупо по буквам, хотя можно было не сравнивать с буквами,
                    {                         // а тупо вогнать все чары из массивов в один арэйлист, но сравнивал, что бы ничего лишнего кроме букв не попало в аррэйлист
                     char m =   alphabet.get(k);
                        itog.add(m);

                    }

                }

            }

        }

        Object[] alphabet0 = alphabet.toArray(); // перевел аррэйлист букв в массив, потому что с ааррэйлистом косячно работало
        Object[] itog0 = itog.toArray(); // аналогично

      ArrayList<Object> itog1 = new ArrayList<>(); // создаю финальный аррэйлист
      for(int i = 0; i<alphabet0.length;i++ ) // вот самый писец, сравнивал массив алфавита с итоговым массивом чаровов
      {                                       // брал первый элемент массива алфавита и прогонял по всему массиву чаров
          int q = 0;                       // создал переменную в первом цикле, а во втором цикле при совпадении букв интерировал переменную, потом когда второй цикл
          for(int j = 0; j< itog0.length;j++ ) // весь прошел и переключилось на следующую букву алфавита, переменная обнулялась потомучто в первом цикле создана
          {
              if(itog0[j].equals((alphabet0[i])))
              {
                  ++q;                             // при совпадении буквы с буквой алфавита интерирую переменную
              }
          }
          itog1.add(alphabet0[i]+" "+q);           // в финальном аррэйлисте кладу буквы по алфавиту и переменную которая отражает сколько раз встретилась данная буква
      }
        for(int i=0; i<itog1.size();i++)
        {
            System.out.println(itog1.get(i).toString()); // печатаю итоговый аррайлист
        }
        }// напишите тут ваш код
    }


