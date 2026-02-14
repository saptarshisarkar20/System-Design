package org.threads.feb14.atomicClasses;


import java.util.concurrent.atomic.AtomicInteger;

class CounterClass {
    private AtomicInteger count;

    public CounterClass() {
        this.count = new AtomicInteger(0);
    }

    public void incrementCount() {
        count.incrementAndGet();
    }

    public void getCount() {
        System.out.println("\nCurrent Count is = " + count.get());
    }
}

class AtomicClassExp {
    public static void main(String[] args) throws InterruptedException {
        CounterClass cc = new CounterClass();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 2000; i++) {
                cc.incrementCount();
//                System.out.print(",+1");
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 2000; i++) {
                cc.incrementCount();
//                System.out.print(",+1");
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        cc.getCount();
    }
}