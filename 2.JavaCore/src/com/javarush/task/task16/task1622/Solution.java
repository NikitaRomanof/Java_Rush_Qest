package com.javarush.task.task16.task1622;

/* 
Последовательные выполнения нитей
1. В методе run после всех действий поставь задержку в 10 миллисекунд. Выведи "Нить прервана", если нить будет прервана.
2. Сделай так, чтобы все нити выполнялись последовательно: сначала для нити №1 отсчет с COUNT до 1, потом для нити №2 с COUNT до 1 и т.д.

Пример:
#1: 4
#1: 3
...
#1: 1
#2: 4
...


Требования:
1. Программа должна создавать 4 объекта типа SleepingThread.
2. Метод main должен вызвать join у каждой создаваемой SleepingThread нити.
3. Метод run должен использовать Thread.sleep(10).
4. Вывод программы должен соответствовать условию.
5. Если нить SleepingThread прерывается, она должна вывести сообщение "Нить прервана".
*/

public class Solution {
    public volatile static int COUNT = 4; // volatile это один из способов обеспечения согласованного доступа к переменной разными потоками

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            new SleepingThread().join(); // тут создаем новый поток и сразуже с помощью метода join() останавливаем main до тех пор пока этот поток не отработает
            //напишите тут ваш код
        }
    }

    public static class SleepingThread extends Thread {
        private static volatile int threadCount = 0;
        private volatile int countdownIndex = COUNT;

        public SleepingThread() {
            super(String.valueOf(++threadCount)); // Для перевода экземпляра любого Java-класса или любого примитивного типа данных к строковому представлению,
           // можно использовать метод String.valueOf()
            // т.е. тут мы пименили конструктор родительского класса, в котором изменили входящий параментр на тип стринг
            //            тут будет заходить переменная threadCount инкрементированная на 1, но в виде стринга
            start();
        }

        public void run() {
            while (true) {
                System.out.println(this);
                try{
                    Thread.sleep(10); // тут усыпляем поток и обрабатываем ошибку интеррапта
                }
                catch (InterruptedException e) {
                    System.out.println("Нить прервана");
                    break;
                }
                if (--countdownIndex == 0) return;
                //напишите тут ваш код
            }
        }

        public String toString() {
            return "#" + getName() + ": " + countdownIndex;
        }
    }
}
