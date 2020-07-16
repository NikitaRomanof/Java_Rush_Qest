package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
CrUD - Create, Update, Delete.

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке.
Все люди должны храниться в allPeople.
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990


Требования:
1. Класс Solution должен содержать public static поле allPeople типа List<Person>.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в конец списка allPeople, и выводить id (index) на экран.
4. При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
5. При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
6. При запуске программы с параметром -i программа должна выводить на экран данные о человеке с заданным id по формату указанному в задании.
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    private static Person getPerson(String name, String sex, String bd) throws ParseException { // тут создали бесполого person, что бы логику выбора м/ж не реализовать в ифах
         Person person = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH); // тут парсер входящей даты

        if(sex.equals("м")) person = Person.createMale(name, simpleDateFormat.parse(bd)); // реализация м/ж . Если м то создаем один персон, если ж - другой.
        else person = Person.createFemale(name, simpleDateFormat.parse(bd));
        return person;
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if (args[0].equals("-c")) {
            Person person = getPerson(args[1], args[2], args[3]); // тут в наш написанный метод getPerson() заводим три стринговых параметра из аргументов
            // и таким образом создаем новый объект персон, а логика выбора м/ж уже реализована в методе getPerson()
            allPeople.add(person); // заносим в лист созданный объект
            System.out.println(allPeople.indexOf(person)); // печатаем id созданного и занесенного в лист объекта
        } else if (args[0].equals("-u")) {
            Person person = getPerson(args[2], args[3], args[4]); // аналогично как и выше
            int id = Integer.parseInt(args[1]); // парсим id из второго входного параметра (не забываем про отсчет с нуля)
            allPeople.set(id, person); // перезаписываем персона в лист

        } else if (args[0].equals("-d")) {
            int id = Integer.parseInt(args[1]); // распарсили ID
            // вот тут непонятка, можно было просто занулить его, но валидатор захотел что бы через встроенные методы класса персон (setName(), setSex(), setBirthDate()) занулились параметры
            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
            allPeople.get(id).setBirthDate(null);
        } else if (args[0].equals("-i")) {
            Person person = allPeople.get(Integer.parseInt(args[1])); // выдернули с помощью гета персона с нужным ID из списка и присвоили ему новую ссылку персон (обрати внимание, что просто get, а не getPerson() )
            Date date = person.getBirthDate(); // выдернули дату рождения персона
            String x; // переменная для печатания на экран пола персона
            if(person.getSex().equals(Sex.MALE)){ // тут ифчик на определение того что печатать в строке пола персона
                x ="м";

            }
            else {
                x ="ж";

            }
            SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH); // для вывода даты именно в том формате, в каком пожелал валидатор
            System.out.println(person.getName() + " " + x + " " + format1.format(date));
        }
    }
}