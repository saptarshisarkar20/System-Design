package org.lld.behavioral.chainOfResponsibility.apr2;

class ThousandHandler1 extends MoneyHandler1 {
    int count;
    int val = 1000;

    ThousandHandler1(int count) {
        this.count = count;
    }

    void setNextHandler(MoneyHandler1 handler) {
        this.nextHandler = handler;
    }

    @Override
    MoneyCount1 dispense(int rs, MoneyCount1 notes) {
        if (rs >= val) {
            int n = rs / val;

            n = Math.min(n, this.count);
            count -= n;

            notes.setRs1000(n);
            System.out.println("\tDispensing " + n + " Rs " + val + " notes");
            rs -= n * val;
        }
        if (rs > 0 && nextHandler != null) {
            return nextHandler.dispense(rs, notes);
        }
        return notes;
    }
}


class FiveHundredHandler1 extends MoneyHandler1 {
    int count;
    int val = 500;

    FiveHundredHandler1(int count) {
        this.count = count;
    }

    void setNextHandler(MoneyHandler1 handler) {
        this.nextHandler = handler;
    }

    @Override
    MoneyCount1 dispense(int rs, MoneyCount1 notes) {
        if (rs >= val) {
            int n = rs / val;

            n = Math.min(n, this.count);
            count -= n;

            notes.setRs500(n);
            System.out.println("\tDispensing " + n + " Rs " + val + " notes");
            rs -= n * val;
        }
        if (rs > 0 && nextHandler != null) {
            return nextHandler.dispense(rs, notes);
        }
        return notes;
    }
}


class HundredHandler1 extends MoneyHandler1 {
    int count;
    int val = 100;

    HundredHandler1(int count) {
        this.count = count;
    }

    void setNextHandler(MoneyHandler1 handler) {
        this.nextHandler = handler;
    }

    @Override
    MoneyCount1 dispense(int rs, MoneyCount1 notes) {
        if (rs >= val) {
            int n = rs / val;

            n = Math.min(n, this.count);
            count -= n;

            notes.setRs100(n);
            System.out.println("\tDispensing " + n + " Rs " + val + " notes");
            rs -= n * val;
        }
        if (rs > 0 && nextHandler != null) {
            return nextHandler.dispense(rs, notes);
        }
        return notes;
    }
}


class FiftyHandler1 extends MoneyHandler1 {
    int count;
    int val = 50;

    FiftyHandler1(int count) {
        this.count = count;
    }

    void setNextHandler(MoneyHandler1 handler) {
        this.nextHandler = handler;
    }

    @Override
    MoneyCount1 dispense(int rs, MoneyCount1 notes) {
        if (rs >= val) {
            int n = rs / val;

            n = Math.min(n, this.count);
            count -= n;

            notes.setRs50(n);
            System.out.println("\tDispensing " + n + " Rs " + val + " notes");
            rs -= n * val;
        }
        if (rs > 0 && nextHandler != null) {
            return nextHandler.dispense(rs, notes);
        }
        return notes;
    }
}


public class COR1 {
    public static void main(String[] args) {
        MoneyHandler1 h1 = new ThousandHandler1(5);
        MoneyHandler1 h2 = new FiveHundredHandler1(3);
        MoneyHandler1 h3 = new HundredHandler1(9);
        MoneyHandler1 h4 = new FiftyHandler1(7);

        h1.setNextHandler(h2);
        h2.setNextHandler(h3);
        h3.setNextHandler(h4);

        int rs = 7750;
        System.out.println("Withdrawing Rs " + rs);
        MoneyCount1 notes = h1.dispense(rs, new MoneyCount1());
        if (notes.CalcTotal() == rs) System.out.println("Withdraw Success");
        else
            System.out.println("Withdraw Failed. Not enough notes available. " + rs + " " + notes.CalcTotal() + " " + (rs - notes.CalcTotal()));
    }
}