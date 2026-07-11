package org.lld.problems.tictactoe.entity;

import org.lld.problems.tictactoe.enums.Symbol;

public abstract class Rules {
    public boolean isValidMove(Board grid, int x, int y) {
        return false;
    }

    public Symbol isWin(Board grid, Symbol s) {
        return null;
    }

    public boolean isDraw(Board grid) {
        return false;
    }
}