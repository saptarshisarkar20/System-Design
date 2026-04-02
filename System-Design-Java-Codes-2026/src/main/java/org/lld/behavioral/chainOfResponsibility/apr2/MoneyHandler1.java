package org.lld.behavioral.chainOfResponsibility.apr2;

public abstract class MoneyHandler1 {
    MoneyHandler1 nextHandler;


    MoneyHandler1() {
        this.nextHandler = null;
    }

    void setNextHandler(MoneyHandler1 nextHandler) {
        this.nextHandler = nextHandler;
    }

    abstract MoneyCount1 dispense(int rs, MoneyCount1 count);
}