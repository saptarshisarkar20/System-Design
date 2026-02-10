package org.threads.feb11.nonSynchronizedThreads;

class CounterNonSync {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }
}