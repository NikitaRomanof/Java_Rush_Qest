package com.javarush.task.task17.task1720;
/*
Банкомат
Разберись, как работает программа.

Во время тестирования лог содержит следующее:
.....
Добавляем 100, на счету 1100
Добавляем 100, на счету 1200
Тратим 1000, на счету 100
Недостаточно денег
.....

Создан баг:
При списании денег со счета теряются деньги.

Найти и исправить ошибку.


Требования:
1. Класс BankAccount должен содержать private поле balance типа BigDecimal.
2. Метод deposit(String money) класса BankAccount должен делегировать поведение в метод deposit(BigDecimal money).
3. Метод withdraw(String money) класса BankAccount должен делегировать поведение в метод withdraw(BigDecimal money).
4. В методе withdraw(BigDecimal money), если необходимо, используй synchronized.
5. В методе deposit(BigDecimal money), если необходимо, используй synchronized.
*/

public class Bankomat {

    static BankAccount account = new BankAccount("Amigo"); // создаем новый объект класса БанкАккаунт (в самом классе много логики)

    public static volatile boolean isStopped; // маркер остановки цикла, валантайл

    public static void main(String[] args) throws InterruptedException {
        addMoney.start(); // запускаем новый поток посмотри ниже интересная реализация нового потока
        SpendThread spendThread = new SpendThread(); // создаем еще потоки, которые реализуют другую логику отличную от  addMoney
        SpendThread spendThread1 = new SpendThread();
        SpendThread spendThread2 = new SpendThread();
        spendThread.start(); // запускаем потоки
        spendThread1.start();
        spendThread2.start();
        Thread.sleep(4000); // метод мэйн спит 4 секунды
        isStopped = true; // меняем маркер прерывания на true и интераптим все потоки
    }

    private static Thread addMoney = new Thread() {
        @Override
        public void run() {
            while (!isStopped) { // обрати внимание что и в этом потоке используется маркер прерывания
                account.deposit("1000");   //кладем на счет, вызовом метода депозит из класса BankAccount

                                try {
                    Thread.sleep(1000); // усыпляем этот пото на 1 секунду
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    };
    /*вроде как была созда просто переменная addMoney типа Thread  со ссылкой на новый объект Thread , однако данная реализация аналогична
    реализации класса, обрати внимание, что переписанный метод run обернут в {} , а после закрывающей скобки идет ";"  */


    public static class SpendThread extends Thread { // рвсписываем логику потока трат денег

        @Override
        public void run() {
            while (!isStopped) { // используем наш маркер прерывания
                try {
                    account.withdraw("100");             //снимаем со счета, вызываем метод класса BankAccount
                } catch (NotEnoughMoneyException e) {
                    System.out.println("Недостаточно денег");
                }
                try {
                    Thread.sleep(100);  // усыпляем поток на 1 секунду
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
