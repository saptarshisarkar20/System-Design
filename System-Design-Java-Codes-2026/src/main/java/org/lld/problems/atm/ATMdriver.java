package org.lld.problems.atm;

import org.lld.problems.atm.cor.Dispense100;
import org.lld.problems.atm.cor.Dispense2000;
import org.lld.problems.atm.cor.Dispense500;

public class ATMdriver {
    public static void main(String[] args) {
        Dispense2000 d2000 = new Dispense2000();
        Dispense500 d500 = new Dispense500();
        Dispense100 d100 = new Dispense100();

        d2000.setNextChain(d500);
        d500.setNextChain(d100);
        int amt = 12300;
        System.out.println("=============== Dispensing - " + amt + " ======================");
        d2000.dispense(amt);

        amt = 900;
        System.out.println("=============== Dispensing - " + amt + " ======================");
        d2000.dispense(amt);

        amt = 500;
        System.out.println("=============== Dispensing - " + amt + " ======================");
        d2000.dispense(amt);

        amt = 300;
        System.out.println("=============== Dispensing - " + amt + " ======================");
        d2000.dispense(amt);

    }
}