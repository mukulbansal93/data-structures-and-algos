package info.mb.dsalgo.practice.threading;

import java.util.concurrent.Semaphore;

/**
 * @author Mukul Bansal
 */
public class PrinterUsingSemaphore {

    Semaphore semaphore = new Semaphore(1);
    volatile int turn = 1;

    class Printer1 implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (turn == 1) {
                    System.out.print("Pay");
                    turn = 2;
                }
                semaphore.release();

            }
        }
    }

    class Printer2 implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (turn == 2) {
                    System.out.print("T");
                    turn = 3;
                }
                semaphore.release();
            }
        }
    }

    class Printer3 implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (turn == 3) {
                    System.out.print("m ");
                    turn = 1;
                }
                semaphore.release();
            }
        }
    }

}