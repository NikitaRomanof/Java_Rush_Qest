package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static
    {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            firstFileName = reader.readLine();
            secondFileName= reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
       f.join();//без этого join поток не успеет вывести на экран то что прочитал, потому что быстрее закроется
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        public String fullFileName;
        public ArrayList<String> fileContents = new ArrayList<>();

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;


        }
        @Override
        public void run(){
            try {
                BufferedReader fileRead = new BufferedReader(new InputStreamReader(new FileInputStream(fullFileName)));
                while(fileRead.ready()){
                   fileContents.add(fileRead.readLine());
                }
                fileRead.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        @Override
        public String getFileContent() {
            String listString = "";

            for (String s : fileContents)
            {
                listString += s + " ";
            }
            return listString;
        }
    } //add your code here - добавьте код тут
}
