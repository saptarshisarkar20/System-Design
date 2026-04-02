package org.lld.structural.facade.mar30;

public class ComputerStart {

    static ComputerStartFacade computerStartFacade = new ComputerStartFacade();

    static void switchOn() {
        computerStartFacade.StartComp();
    }

    public static void main(String[] args) {
        switchOn();
    }
}