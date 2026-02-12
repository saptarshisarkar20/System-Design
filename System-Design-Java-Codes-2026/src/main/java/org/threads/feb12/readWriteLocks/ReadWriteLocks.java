package org.threads.feb12.readWriteLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReadWrite {
    int count = 0;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void increment() {
        writeLock.lock();
        try {
            count++;
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
        readLock.lock();
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }
}


class ReadWriteLocks {
    public static void main(String[] args) {


        ReadWrite count = new ReadWrite();
        Runnable write = new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 30; j++) {
                    count.increment();
                    System.out.println(Thread.currentThread().getName() + " is increamenting ");
                }
            }
        };

        Runnable read = new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10; j++) {
                    System.out.println(Thread.currentThread().getName() + " is reading : " + count.getCount());
                }
            }
        };

        Thread t1 = new Thread(write, "Thrd - 1");
        Thread t2 = new Thread(read, "Thrd - 2");
        Thread t3 = new Thread(read, "Thrd - 3");

        t1.start();
        t2.start();
        t3.start();

    }

}