package org.threads.feb10.thredPriority;

class ThreadPriority extends Thread {

    //Naming a thread
    public ThreadPriority(String name) {
        super(name);
    }

    @Override
    public void run() {
        int i = 0;
        for (; i < 10; i++) {
            int x = Integer.MAX_VALUE;
            StringBuilder s = new StringBuilder();
            for (int j = 1; j < 100000; j++) {
                x = x % j;
                s.append(x);
            }
            System.out.println(i + ") Curr Thread : " + currentThread().getName() + " | Priority : " + currentThread().getPriority());
        }
    }

    public static void main(String[] args) {
        ThreadPriority ll = new ThreadPriority("LOW PP ");
        ll.setPriority(MIN_PRIORITY);

        ThreadPriority mm = new ThreadPriority("MID PP ");
        mm.setPriority(NORM_PRIORITY);

        ThreadPriority hh = new ThreadPriority("HIGH PP");
        hh.setPriority(MAX_PRIORITY);

        ll.start();
        mm.start();
        hh.start();
    }
}