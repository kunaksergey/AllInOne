package ua.shield.test;

import java.io.IOException;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;
import static java.lang.Thread.yield;

/**
 * Created by sa on 31.01.17.
 */
public class Main {
    private static int SIZE = 2;
    private static Semaphor semaphor = new Semaphor(SIZE);
    private static final boolean[] PARKINGPLACE = new boolean[SIZE];

    public static void main(String[] args) {
        Semaphor semaphor = new Semaphor(3);
        for (int i = 1; i < 11; i++) {
            new Thread(new CarInner(i * 1000 + i * 100 + i * 10 + i)).start();
        }
    }


    private static class CarInner implements Runnable {
        private final int number;

        public CarInner(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            semaphor.start();
            System.out.println("Машина: " + number + " заехала на парковку");
            int num = -1;
            synchronized (PARKINGPLACE) {
                for (int i = 0; i < SIZE; i++) {
                    if (PARKINGPLACE[i] == false) {
                        PARKINGPLACE[i] = true;
                        num = i;
                        printParkingPlace();
                    }
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (PARKINGPLACE) {
                PARKINGPLACE[num] = false;
            }

            System.out.println("Машина: " + number + " выехала с парковки");
            printParkingPlace();
            semaphor.stop();

        }

    }

    static void printParkingPlace() {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < PARKINGPLACE.length; i++) {
            str.append(" Место №1:" + PARKINGPLACE[i]);
        }
        System.out.println(str);
    }
}
