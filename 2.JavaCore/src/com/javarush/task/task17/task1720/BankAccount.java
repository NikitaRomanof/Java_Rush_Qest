package com.javarush.task.task17.task1720;

import java.math.BigDecimal;

public class BankAccount {
    private BigDecimal balance;  // обрати внимание все переменные в которых хранятся деньги должны быть BigDecimal!!!
    private String owner; // приватное поля имени хозяина счета

    public BankAccount(String owner) { // первый конструктор включающий в себя только имя хозяимна
        this(BigDecimal.ZERO, owner); // нужно почитать про BigDecimal класс, но чисто логически тут видно, что
        // в данный конструктор вводится только имя хозяина счета, а баланс счета задаётся нулевым, благодоря этой строчке кода
    }

    public BankAccount(BigDecimal balance, String owner) { // второй конструктор, тут уже задается баланс и имя держателя счета
        this.balance = balance;
        this.owner = owner;
    }

    public synchronized void deposit(BigDecimal money) { // основной метода для депозита
        BigDecimal newBalance = balance.add(money); // эта функция ВИДИМО создает новый баланс который состоит из стараго баланса плюс вошедшей переменной money в этот метод
        System.out.println("Добавляем " + money + ", на счету " + newBalance);
        balance = newBalance; // тут ссылка на объект старого баланса, начинает ссылаться на объект нового баланса, а старый баланс видимо будет удален сборщиком мусора
    }

    public synchronized void withdraw(BigDecimal money) throws NotEnoughMoneyException {  // основной метода для депозита для вывода денег со счета
        BigDecimal newBalance = balance.subtract(money); // незнаю что значит метод subtract класса  BigDecimal, но видимо вычитание из баланса аналагично тому как и в методе депозита

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) throw new NotEnoughMoneyException(); // если денег на счету меньше нуля, то кидает исключение
        // причем исключение самописное, но логика не расписана, оно просто унаследывает все исключения

        balance = newBalance; // дальше реализация метода аналогична депозиту
        System.out.println("Тратим " + money + ", на счету " + balance);
    }

    public void deposit(String money) {
        deposit(new BigDecimal(money));
    }

    public void withdraw(String money) throws NotEnoughMoneyException {
        withdraw(new BigDecimal(money));
    }
}
