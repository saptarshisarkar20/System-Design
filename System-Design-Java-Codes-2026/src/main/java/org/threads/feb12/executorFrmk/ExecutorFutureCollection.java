package org.threads.feb12.executorFrmk;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ExecutorFutureCollection {
    public static <T> void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<Integer> c1 = () -> {
            System.out.println("task 1");
            return 1;
        };
        Callable<Integer> c2 = () -> {
            System.out.println("task 2");
            return 1;
        };
        Callable<Integer> c3 = () -> {
            System.out.println("task 3");
            return 1;
        };

        List<Callable<Integer>> ll = Arrays.asList(c1, c2, c3);

        List<Future<Integer>> futures = executorService.invokeAll(ll);
        // the main thread will wait for the shutdown this time;
        executorService.shutdown();
        System.out.println("task completed");

    }
}