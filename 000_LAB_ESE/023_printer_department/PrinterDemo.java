class Printer {
    String department;

    Printer(String department) {
        this.department = department;
    }

    synchronized void printNumbers() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Department: " + department + " Number: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Do nothing
            }
        }
    }
}

public class PrinterDemo {
    public static void main(String[] args) {
        Printer printer1 = new Printer("HR");
        Printer printer2 = new Printer("Finance");

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                printer1.printNumbers();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                printer2.printNumbers();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // Do nothing
        }
    }
}
