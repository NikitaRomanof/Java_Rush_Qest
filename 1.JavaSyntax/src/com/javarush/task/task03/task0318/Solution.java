package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
       String num = bufferedReader.readLine();
       String name = bufferedReader.readLine();


        System.out.print(name + " захватит мир через " + num + " лет. Му-ха-ха!");



    }
}
