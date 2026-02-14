package org.threads.feb14.cyclicBarrier;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Subsystem implements Runnable {
    private String name;
    private int time;
    private final CyclicBarrier barrier;

    public Subsystem(CyclicBarrier barrier, int time, String name) {
        this.barrier = barrier;
        this.time = time;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " called");
            Thread.sleep(time);
            System.out.println(name + " >< Service Running");
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println(name + " X exception");
        }
    }
}


class CyclicBarrierExp {
    public static void main(String[] args) {

        int tasks = 4;
        CyclicBarrier barrier = new CyclicBarrier(tasks, () -> {
            System.out.println("All subsystems are up & Running :)");
        });

        Thread t1 = new Thread(new Subsystem(barrier, 2000, "Web Server"));
        Thread t2 = new Thread(new Subsystem(barrier, 4000, "Data Base"));
        Thread t3 = new Thread(new Subsystem(barrier, 5000, "cache"));
        Thread t4 = new Thread(new Subsystem(barrier, 3000, "kafka"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println("main thread");

    }

}