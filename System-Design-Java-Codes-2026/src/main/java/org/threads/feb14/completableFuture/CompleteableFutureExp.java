package org.threads.feb14.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class CompleteableFutureExp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // by defaut runs on the deamon thread
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("running future >> " + Thread.currentThread().getName());
                Thread.sleep(3000);
                System.out.println("future completed >> " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return " up ";
        }).thenApply((x) -> "service is" + x);

        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("running future >> " + Thread.currentThread().getName());
                Thread.sleep(2500);
                System.out.println("future completed >> " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 200;
        });

        // returns nothing multiple return types of multiple futures
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(f1, f2);
//        f2.get(); // blocking call
        System.out.println("Main Thread : " + Thread.currentThread().getName());
    }
}