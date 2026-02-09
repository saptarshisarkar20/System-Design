package org.threads.feb10.mainThread;

class MainThreadEg {
    public static void main(String[] args) {
        System.out.println("Hello Java Threads!");
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getName());

//        ## OUTPUT ->
//        Hello Java Threads!
//        1
//        main
    }
}