package com.javarush.task.task14.task1421;

public class Singleton {
    private static  Singleton instance;
    private Singleton(Singleton instance){
       this.instance= instance;
    }
    public static Singleton getInstance(){
        return instance;
    }
}
