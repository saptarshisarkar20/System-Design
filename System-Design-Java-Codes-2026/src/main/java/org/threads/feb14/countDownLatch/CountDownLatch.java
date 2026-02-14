package org.threads.feb14.countDownLatch;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ServiceTask implements Callable<Integer> {

    private final CountDownLatch latch;

    ServiceTask(CountDownLatch latch) {
        this.latch = latch;
    }


    @Override
    public Integer call() throws Exception {
        try {
            System.out.println("Service Running : " + Thread.currentThread().getName());
            Thread.sleep(5000);
        } finally {
            latch.countDown();
        }
        return 0;
    }
}


class CountDownLatchEx {
    public static void main(String[] args) throws InterruptedException {
        int tasks = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(tasks);
        CountDownLatch latch = new CountDownLatch(tasks);
        executorService.submit(new ServiceTask(latch));
        executorService.submit(new ServiceTask(latch));
        executorService.submit(new ServiceTask(latch));
        latch.await();

        // main thread will wait for the latch to countdown
        System.out.println("back into main thread : " + Thread.currentThread().getName());
        executorService.shutdown();

    }
}