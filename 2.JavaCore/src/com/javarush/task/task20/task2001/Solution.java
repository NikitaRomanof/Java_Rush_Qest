package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
Реализуй логику записи в файл и чтения из файла для класса Human.
Поле name в классе Human не может быть пустым.
Метод main реализован только для вас и не участвует в тестировании.


Требования:
1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список assets пустой.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если поле name и список assets не пустые.
3. Класс Solution.Human не должен поддерживать интерфейс Serializable.
4. Класс Solution.Human должен быть публичным.
5. Класс Solution.Human не должен поддерживать интерфейс Externalizable.
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
           // File your_file_name = File.createTempFile("your_file_name", ".TXT");// - тут создается временный файл,что бы не париться просто ниже прописал путь к тестовому файлу
            OutputStream outputStream = new FileOutputStream("C:\\Users\\Home\\Desktop\\firstFile.txt"); // один файл на запись и чтение
            InputStream inputStream = new FileInputStream("C:\\Users\\Home\\Desktop\\firstFile.txt");

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99)); // для теста создаем объект Human
            ivanov.save(outputStream);//  реализуем написанную ниже логику(вся суть данной задачи) сохранения
            outputStream.flush();

            Human somePerson = new Human(); // реализуем написанную ниже логику(вся суть данной задачи) загрузки
            somePerson.load(inputStream);
            inputStream.close();
            System.out.println(somePerson.equals(ivanov));//check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human { // класс Human имеет два поля типа стринг и лист с данными типа Asset
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) { // этот конструктор говорит что Asset в листе assets может быть сколько угодно
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) { //  переопределенный метод еквалс, что бы корректно сравнить значения до сохранения и после сохранения, аналогично для hashCode()
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            String isNamePresent = name != null ? "yes" : "no"; // строка для проверки того пусто или нет поле name
            printWriter.println(isNamePresent);
            printWriter.flush();

            if (name != null){ // если name не null то сохраняем его в файл с помощью PrintWriter
                printWriter.println(name);
                printWriter.flush();
            }



            String isAssetsPresent = !assets.isEmpty() ? "yes" : "no"; // проверка для листа, если личст не пустой, то сохраняем его
            printWriter.println(isAssetsPresent);
            printWriter.flush();

            if (!assets.isEmpty()){

                for (Asset asset : assets) {
                    printWriter.print(asset.toString()+" "); // переводим каждый элемент листа в строку и сохраняем в одну строчку (важно print(), а не println()) через пробел.
                    // Что бы корректно работало, переопределяем toString() в классе Asset
                    //System.out.print(asset.toString()+" ");// проверка
                }
                printWriter.flush(); // сохраняем все из буфера


            }



            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String isNamePresent = reader.readLine();// тут все просто, если isNamePresent== yes, то считываем строку и сохраняем это значение в name
            if (isNamePresent.equals("yes")) {
                name = reader.readLine();
            }

            String isAssetsPresent = reader.readLine();
            if (isAssetsPresent.equals("yes")) { // тут по сложнее, если "маркер" - да, то нужно считать строку, разбить ее на массив по пробелам и отрезать лишний пробел

                String data = reader.readLine().trim();
                String[] all = data.split(" ");
                //System.out.println("");// проверка
                for(int i = 0; i<all.length-1; ){ // потом пройтись по полученному массиву, где все четные элементы и нулевой элемент это строка, все нечентые это число
                    // тут же сразу парсим число
                    double x = Double.parseDouble(all[i+1]);
                    //System.out.println("Это строка: " + all[i]);
                    //System.out.println("Это double: " + x);
                    assets.add(new Asset(all[i],x)); // и из полученных значений в каждой интерации цикла(важно, цикл на 1 меньше длины массива) создаем новый объект Asset и ложим его в лист
                    i = i+2;// инкрементируем переменную цикла на 2а за шаг, так как мы по два элемента массива перебираем за раз

                }


               // assets.addAll(new Asset(reader.readLine()))
            }
            //implement this method - реализуйте этот метод
        }
    }
}
