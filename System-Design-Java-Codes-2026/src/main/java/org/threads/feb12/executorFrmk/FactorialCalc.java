package org.threads.feb12.executorFrmk;

class FactorialCalc {
    public static long calcFact(int x) {
        long ans = 1;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 1; i <= x; i++) {
            ans *= i;
        }
        return ans;
    }
}