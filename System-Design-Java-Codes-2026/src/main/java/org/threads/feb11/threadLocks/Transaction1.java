package org.threads.feb11.threadLocks;

class Transaction1 {
    public static void main(String[] args) {
        BankAccount1 sbi = new BankAccount1(200);
        Runnable rr = new Runnable() {
            @Override
            public void run() {
                sbi.windrawMoney(50);
            }
        };

        Thread t1 = new Thread(rr, "Thrd - 1");
        Thread t2 = new Thread(rr, "Thrd - 2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Current balance: " + sbi.getBalance());

    }
}