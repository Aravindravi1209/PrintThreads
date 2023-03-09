package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {

        for(int i=0;i<3;i++)
        {
            PrintNumbers printNumbers = new PrintNumbers(i, 100);
            Thread thread = new Thread(printNumbers);
            thread.start();
        }


    }
}