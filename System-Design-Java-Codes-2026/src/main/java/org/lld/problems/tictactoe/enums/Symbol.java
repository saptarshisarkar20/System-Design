package org.lld.problems.tictactoe.enums;

public enum Symbol {
    X("X"),
    O("O"),
    EMPTY(" ");

    private final String value;

    Symbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}