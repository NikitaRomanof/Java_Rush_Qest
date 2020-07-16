package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль каждое имя и сумму всех его значений, все данные должны быть отсортированы в возрастающем порядке по имени.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader2 = new BufferedReader(fileReader);

        ArrayList<String> data = new ArrayList<>();
        String str;

        while ((str = reader2.readLine()) != null)   {
           data.add(str);

        }
        fileReader.close();
        reader2.close();

        ArrayList<String> lastName = new ArrayList<>();
        ArrayList<Double> numbers = new ArrayList<>();
        for(int i = 0; i < data.size(); i++) {

            String x = data.get(i).substring(0,data.get(i).indexOf(" "));
            double y = Double.parseDouble(data.get(i).substring(data.get(i).lastIndexOf(" ")));
            lastName.add(x);
            numbers.add(y);
        }
        TreeMap<String, Double> personMap = new TreeMap<>(); // создаем мапу которая сразу сортирует по ключам
        //System.out.println(lastName); // самопроверка

        for (int i = 0; i < lastName.size(); i++) { // в первом цикле берем первое значение lastName
            double  sum1 = 0.0;// сумму чисчел сохраняем в этой переменной, что бы когда будет браться следующее значяение для сравнения, то сумма сбросится


                for(int j = i+1; j < lastName.size(); j++) { // во втором цикле сравниваем взятое значение со всеми остальными

                    //System.out.println(lastName.get(i) + " сравниваем с " + lastName.get(j)  ); // самопроверка
                    if( lastName.get(i).equals(lastName.get(j)) && !lastName.get(i).equals("x")) { // если взятое значение совподает с другим значением, то
                       sum1 = sum1 + numbers.get(i) + numbers.get(j) ; // из второго листа складываем числа, причем складываем с суммой
                        // при этом полученное число сохраняем, что бы в дальнейшем если будудут совпадаения, то перезаписалось большее число
                        personMap.put(lastName.get(i),sum1); // записываем в мапу где кей - строка, валуе - число

                        lastName.set(j,"x"); // и самое главное зануляем сразу то значение(занулить нельзя, присвиваем х для проверки потом), которое совпало со взятым, что бы не было поваторов
                        numbers.set(i,0.0); //зануляем текущее числовое значение для проверки потом (можно не занулять а придать минимальнео значение)
                        numbers.set(j,0.0); // зануляем и совпавшее числовое значение, так как мы не можем тут занулить строку, иначе после первого совпадения она не найдет совпадения дальше
                        // потом будем проверять на ноль число и на х строку что бы добавить в мапу не повторяющиеся знаячения
                    }

                }

        }

        for (int i = 0; i < lastName.size(); i++) { // тут добавляем в мапу все несовпавшее значения
            if(!lastName.get(i).equals("x") && numbers.get(i)!=0.0 ){ // проверяем на нули, если не ноль в списке чисел и не х в списке стрингов, то добавляем в мапу
                personMap.put(lastName.get(i),numbers.get(i));
            }

        }
        for(Map.Entry<String, Double> pair : personMap.entrySet() ) { // печатаем фо ичем то что получилось
            System.out.println(pair.getKey() + " " + pair.getValue() );
        }
    }
}
// и да можно было все циклы for заменить одним методом map.merge(), но цель была написать без этого метода, так как формально для этой задачи он еще не изучался
