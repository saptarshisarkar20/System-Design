package org.threads.feb10.waysToDefineThread;

public class Hello2 {

    public static void main(String[] args) {

        World2 ww = new World2();
        Thread tt = new Thread(ww);
        tt.start();

        for (int i = 0; i < 10000; i++) {
            System.out.println("Hello >> current thread = " + Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}