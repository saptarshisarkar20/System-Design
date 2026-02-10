package org.threads.feb11.nonSynchronizedThreads;

class MyThread1 extends Thread {
    private CounterNonSync counter;

    MyThread1(CounterNonSync counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            counter.increment();
        }
    }
}