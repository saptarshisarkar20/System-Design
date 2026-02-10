package org.threads.feb11.nonSynchronizedThreads;

class Test1 {
    public static void main(String[] args) {
        CounterNonSync counter = new CounterNonSync();
        MyThread1 t1 = new MyThread1(counter);
        MyThread1 t2 = new MyThread1(counter);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Expected count = 4000 || Current count = " + counter.getCount());
    }
}