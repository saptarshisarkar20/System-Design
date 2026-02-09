package org.threads.feb10.daemonThreads;

public class DaemonThreads extends Thread {
    /**
     * A daemon thread in Java is a low‑priority background thread that supports other (user) threads and does not prevent the JVM from shutting down once all user threads finish.
     */

    @Override
    public void run() {
        int i = 1;
        while (true) {
            System.out.println(i++ + "Daemon Thread is running...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DaemonThreads dt = new DaemonThreads();
        dt.setDaemon(true);
        dt.start();
        sleep(15);
        System.out.println("XX Main Thread here XX");
    }
}