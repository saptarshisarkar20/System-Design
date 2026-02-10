package org.threads.feb11.synchronizedThreads;

class Test2 {
    public static void main(String[] args) {
        CounterSync counter = new CounterSync();
        MyThread2 t1 = new MyThread2(counter);
        MyThread2 t2 = new MyThread2(counter);
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