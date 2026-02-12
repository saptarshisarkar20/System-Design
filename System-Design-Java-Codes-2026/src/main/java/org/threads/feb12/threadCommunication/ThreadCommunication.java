package org.threads.feb12.threadCommunication;

class SharedResource {

    private int data;
    private boolean hasData;

    public synchronized void produce(int val) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = val;
        hasData = true;
        System.out.println("Produced val : " + val);
        notify();
    }

    public synchronized int consume() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        notify();
        System.out.println("Consumed val : " + data);
        return data;
    }
}

class Producer implements Runnable {
    private SharedResource sharedResource;

    Producer(SharedResource resource) {
        this.sharedResource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedResource.produce(i);
        }
    }
}

class Consumer implements Runnable {
    private SharedResource sharedResource;

    Consumer(SharedResource resource) {
        this.sharedResource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int val = sharedResource.consume();
        }
    }
}


class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread pt = new Thread(new Producer(resource), "Producer Thread");
        Thread ct = new Thread(new Consumer(resource), "Consumer Thread");

        pt.start();
        ct.start();
    }
}