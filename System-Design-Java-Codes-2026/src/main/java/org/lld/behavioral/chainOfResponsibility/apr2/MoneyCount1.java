package org.lld.behavioral.chainOfResponsibility.apr2;

public class MoneyCount1 {
    int rs1000;
    int rs500;
    int rs100;
    int rs50;

    public MoneyCount1() {
        this.rs1000 = 0;
        this.rs500 = 0;
        this.rs100 = 0;
        this.rs50 = 0;
    }

    public MoneyCount1(int rs1000, int rs500, int rs100, int rs50) {
        this.rs1000 = rs1000;
        this.rs500 = rs500;
        this.rs100 = rs100;
        this.rs50 = rs50;
    }

    public int CalcTotal() {
        return 1000 * rs1000 + 500 * rs500 + 100 * rs100 + 50 * rs50;
    }

    public int getRs1000() {
        return rs1000;
    }

    public void setRs1000(int rs1000) {
        this.rs1000 = rs1000;
    }

    public int getRs500() {
        return rs500;
    }

    public void setRs500(int rs500) {
        this.rs500 = rs500;
    }

    public int getRs100() {
        return rs100;
    }

    public void setRs100(int rs100) {
        this.rs100 = rs100;
    }

    public int getRs50() {
        return rs50;
    }

    public void setRs50(int rs50) {
        this.rs50 = rs50;
    }
}