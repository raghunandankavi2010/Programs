package programs.threads;

/** Prints 1 and 2 from two threads alternatively
 *
 */
public class Print12 {

    private final Object object = new Object();
    public static void main(String[] args) {

        PrintEvenOdd print = new PrintEvenOdd();
        Thread t1 = new Thread(new EvenOdd(print, 10, false),"Odd");
        Thread t2 = new Thread(new EvenOdd(print, 10, true),"Even");
        t1.start();
        t2.start();
    }

}


class EvenOdd implements Runnable {
    private final int max;
    private final PrintEvenOdd print;
    private final boolean isEvenNumber;

    public EvenOdd(PrintEvenOdd print, int i, boolean b) {
        this.print = print;
        this. max = i;
        this.isEvenNumber = b;
    }

    @Override
    public void run() {
        int number = isEvenNumber ? 2 : 1;
        while (number <= max) {
            if (isEvenNumber) {
                print.printEven(number);
            } else {
                print.printOdd(number);
            }
            number += 2;
        }
    }
}

class PrintEvenOdd {

    private volatile boolean isOdd;

    synchronized void printEven(int number) {
        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = false;
        notify();
    }

    synchronized void printOdd(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = true;
        notify();
    }
}