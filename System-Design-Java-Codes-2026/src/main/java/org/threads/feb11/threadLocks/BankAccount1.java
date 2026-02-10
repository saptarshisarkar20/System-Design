package org.threads.feb11.threadLocks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount1 {
    private Integer balance;

    // here we are using the lock
    private final Lock lock = new ReentrantLock();

    BankAccount1(Integer bal) {
        this.balance = bal;
    }

    public Integer getBalance() {
        return balance;
    }

    public int windrawMoney(int amount) {

        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (amount <= balance) {
                    System.out.println(Thread.currentThread().getName() + " - started to withdraw money, balance: " + balance);
                    try {
                        // some very big operation
                        Thread.sleep(10000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " - money deducted from the account : " + amount);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " - money successfully withdrawn, balance: " + balance);
                } else {
                    System.out.println(Thread.currentThread().getName() + " - insufficient balance X withdrawal aborted X balance: " + balance);
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " - op locked | thread aborted");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
//        finally {
//            lock.unlock();
//        }
        return balance;
    }
}