package org.lld.problems.atm.cor;

public interface MoneyHandler {
    public void setNextChain(MoneyHandler next);

    public void dispense(int amount);
}