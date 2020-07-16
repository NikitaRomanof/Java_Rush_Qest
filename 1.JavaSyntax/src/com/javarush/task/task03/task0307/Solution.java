package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {

        Zerg A1 = new Zerg ();
        A1.name = "ZogZog1";
        Zerg A2 = new Zerg ();
        A2.name = "ZogZog2";
        Zerg A3 = new Zerg();
        A3.name = "ZogZog3";
        Zerg A4 = new Zerg();
        A4.name = "ZogZog4";
        Zerg A5 = new Zerg();
        A5.name = "ZogZog5";
        Protoss B1 = new Protoss();
        B1.name = "VrumVrum1";
        Protoss B2 = new Protoss ();
        B2.name = "VrumVrum2";
        Protoss B3 = new Protoss();
        B3.name = "VrumVrum3";
        Terran C1 = new Terran();
        C1.name = "Marrin1";
        Terran C2 = new Terran();
        C2.name = "Marrin2";
        Terran C3 = new Terran();
        C3.name = "Marrin3";
        Terran C4 = new Terran();
        C4.name = "Marrin4";//напишите тут ваш код

    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
