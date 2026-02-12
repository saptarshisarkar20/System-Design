package org.threads.feb12.executorFrmk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.threads.feb12.executorFrmk.FactorialCalc.calcFact;

class WithoutExeFrmk {
    public static void main(String[] args) {
        // without multithreading
        long startTime = System.currentTimeMillis();
        System.out.println("factorials without multi-threading :");
        for (int i = 0; i <= 10; i++) {
            System.out.print(i + " -> " + calcFact(i) + " | ");
        }
        System.out.println();
        System.out.println("Time taken Without Multi-threading : ( " + (System.currentTimeMillis() - startTime) + " )ms");

        // With Multithreading
        startTime = System.currentTimeMillis();
        System.out.println("factorials with multi-threading :");
        Thread[] tArr = new Thread[11];
        for (int i = 0; i <= 10; i++) {
            final int fnl = i;
            Thread tt = new Thread(() -> {
                System.out.print(fnl + " -> " + calcFact(fnl) + " | ");
            });
            tArr[i] = tt;
            tt.start();
        }
        for (Thread t : tArr) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
        System.out.println("Time taken With Multi-threading : ( " + (System.currentTimeMillis() - startTime) + " )ms");


        // With Thread Executor
        System.out.println("factorials with Executor thread-pool :");
        startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i <= 10; i++) {
            int finalI = i;
            executor.submit(() -> {
                System.out.print(finalI + " -> " + calcFact(finalI) + " | ");
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("Time taken With Executor thread-pool : ( " + (System.currentTimeMillis() - startTime) + " )ms");
    }
}