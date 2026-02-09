package org.threads.feb10.threadYield;

class ThreadYield extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "> Current thread -> " + currentThread().getName());
            currentThread().yield();
            // A hint to the scheduler that the current thread is willing to yield its current use of a processor. The scheduler is free to ignore this hint.
        }
    }

    public static void main(String[] args) {
        ThreadYield th1 = new ThreadYield();
        ThreadYield th2 = new ThreadYield();

        th1.start();
        th2.start();
    }
}
//         0> Current thread -> Thread-0
//        0> Current thread -> Thread-1
//        1> Current thread -> Thread-0
//        1> Current thread -> Thread-1
//        2> Current thread -> Thread-0
//        2> Current thread -> Thread-1
//        3> Current thread -> Thread-0
//        3> Current thread -> Thread-1
//        4> Current thread -> Thread-0
//        4> Current thread -> Thread-1
//        5> Current thread -> Thread-0
//        5> Current thread -> Thread-1
//        6> Current thread -> Thread-0
//        6> Current thread -> Thread-1
//        7> Current thread -> Thread-0
//        7> Current thread -> Thread-1
//        8> Current thread -> Thread-0
//        8> Current thread -> Thread-1
//        9> Current thread -> Thread-1
//        9> Current thread -> Thread-0