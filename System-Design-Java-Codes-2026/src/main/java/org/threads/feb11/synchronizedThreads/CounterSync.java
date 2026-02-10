package org.threads.feb11.synchronizedThreads;

class CounterSync {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public synchronized void increment() {
        count++;
    }
    // other way to synchronize
    /*
    public  void increment() {
        synchronized (){
            count++;
        }
    }
     */
}