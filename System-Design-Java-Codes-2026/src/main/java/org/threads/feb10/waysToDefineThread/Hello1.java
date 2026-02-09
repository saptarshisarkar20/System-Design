package org.threads.feb10.waysToDefineThread;

public class Hello1 {
    public static void main(String[] args) throws InterruptedException {

        World1 ww = new World1();
        ww.start();

        for (int i = 0; i < 10000; i++) {
            System.out.println("Hello >> current thread = " + Thread.currentThread().getName());
            Thread.sleep(10);
        }
    }
}