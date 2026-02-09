package org.threads.feb10.threadInterrupt;

class ThreadInterrupt extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Thread is going to Sleep :)");
            Thread.sleep(5000);
            System.out.println("Thread sleep completed :)");
        } catch (InterruptedException e) {
            System.out.println("Thread sleep Interrupted :( || " + e);
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadInterrupt th = new ThreadInterrupt();
        th.start();
        th.interrupt();

//        Thread is going to Sleep :)
//        Thread sleep Interrupted :( || java.lang.InterruptedException: sleep interrupted
    }
}