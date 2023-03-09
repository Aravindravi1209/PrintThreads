package org.example;

public class PrintNumbers implements Runnable{

    int remainder;
    int printUpto;
    public PrintNumbers(int remainder, int printUpto) {
        this.remainder = remainder;
        this.printUpto = printUpto;
    }
    static int number=1;
    static int counter=1;
    static Object lock=new Object();


    @Override
    public void run() {
        while (counter < printUpto * 3 - 1) {
            synchronized (lock) {
                while (counter % 3 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                if (counter % 3 == 0) {
                    number++;
                }
                counter++;
                lock.notifyAll();
            }
        }
    }

}