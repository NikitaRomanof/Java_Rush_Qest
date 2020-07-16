package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>();

    public static void main(String[] args) {
        SpecialThread obj1 = new SpecialThread();
        Thread specialThread1 = new Thread(obj1);
        specialThread1.start();
        list.add(specialThread1);
        SpecialThread obj2 = new SpecialThread();
        Thread specialThread2 = new Thread(obj2);
        specialThread2.start();
        list.add(specialThread2);
        SpecialThread obj3 = new SpecialThread();
        Thread specialThread3 = new Thread(obj3);
        specialThread3.start();
        list.add(specialThread3);
        SpecialThread obj4 = new SpecialThread();
        Thread specialThread4 = new Thread(obj4);
        specialThread4.start();
        list.add(specialThread4);
        SpecialThread obj5 = new SpecialThread();
        Thread specialThread5 = new Thread(obj5);
        specialThread5.start();
        list.add(specialThread5);
        //Add your code here - добавьте свой код тут
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
