package org.threads.feb12.lambdaExp;


class LambdaExpression {
    public static void main(String[] args) {

        // runnable implementation using lambda function
        Runnable runnable = () -> {
            System.out.println("Hello World! Runnable is running");
        };

        Thread t1 = new Thread(runnable);
        t1.start();
    }
}