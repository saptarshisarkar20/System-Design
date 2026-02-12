package org.threads.feb12.executorFrmk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ExecutorFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> submit = executorService.submit(() -> 1 + 2);
        System.out.println(submit.isDone());
        int x = submit.get(); // main thread will wait untill the future get resolved
        System.out.println(x);
        System.out.println(submit.isDone());
        executorService.shutdown();
        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());
        Thread.sleep(1);
        System.out.println(executorService.isTerminated());
    }
}