package org.threads.feb11.synchronizedThreads;

class MyThread2 extends Thread {
    private CounterSync counter;

    MyThread2(CounterSync counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            counter.increment();
        }
    }
}