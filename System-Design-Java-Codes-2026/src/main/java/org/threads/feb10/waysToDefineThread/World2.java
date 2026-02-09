package org.threads.feb10.waysToDefineThread;

public class World2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("World >> current thread = " + Thread.currentThread().getName());
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}