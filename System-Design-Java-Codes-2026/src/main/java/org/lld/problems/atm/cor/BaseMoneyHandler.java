package org.lld.problems.atm.cor;

import org.lld.problems.atm.entity.Notes;

public abstract class BaseMoneyHandler implements MoneyHandler {
    private final Notes note;
    private MoneyHandler next;

    public BaseMoneyHandler(Notes note) {
        this.note = note;
    }

    @Override
    public void setNextChain(MoneyHandler next) {
        this.next = next;
    }

    @Override
    public void dispense(int amount) {

        int cnt = amount / note.getDenomination();
        int remaining = amount % note.getDenomination();
        if (cnt > 0) {
            System.out.println("Dispensing " + cnt + " notes of INR " + note.getDenomination());
        }
        if (next != null) next.dispense(remaining);
    }
}