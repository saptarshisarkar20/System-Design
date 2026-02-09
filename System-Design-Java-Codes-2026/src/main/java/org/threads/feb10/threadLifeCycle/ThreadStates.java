package org.threads.feb10.threadLifeCycle;

class ThreadStates extends Thread {
    @Override
    public void run() {
        System.out.println("Current Thread > " + Thread.currentThread().getName() + " | State >> RUNNING + " + Thread.currentThread().getState());
        // there is no RUNNING state in thread. So, it shows RUNNABLE also while it is running
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadStates ts = new ThreadStates();
        System.out.println("Current Thread > " + ts.getName() + " | State >> " + ts.getState());
        ts.start(); // the thread will start running
        System.out.println("Current Thread > " + ts.getName() + " | State >> " + ts.getState());
        Thread.sleep(1000); // main thread will sleep so the other thread can start execution
        System.out.println("Current Thread > " + ts.getName() + " | State >> " + ts.getState());
        ts.join(); // the other thread process will join with the main thread
        System.out.println("Current Thread > " + ts.getName() + " | State >> " + ts.getState());
    }
}