package org.lld.problems.tictactoe.entity;

import org.lld.problems.tictactoe.enums.Symbol;

import java.util.List;

public class StandardRules extends Rules {
    public boolean isValidMove(Board grid, int x, int y) {
        return grid.isPositionEmpty(x, y);
    }

    public boolean isDraw(Board grid) {
        return !grid.anyPositionEmpty();
    }

    public Symbol isWin(Board board, Symbol s) {
        List<List<Symbol>> grid = board.grid;
        int n = grid.size();

        // Check rows
        for (int i = 0; i < n; i++) {
            boolean win = true;
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) != s) {
                    win = false;
                    break;
                }
            }
            if (win) return s;
        }

        // Check columns
        for (int j = 0; j < n; j++) {
            boolean win = true;
            for (int i = 0; i < n; i++) {
                if (grid.get(i).get(j) != s) {
                    win = false;
                    break;
                }
            }
            if (win) return s;
        }

        // Check main diagonal
        boolean win = true;
        for (int i = 0; i < n; i++) {
            if (grid.get(i).get(i) != s) {
                win = false;
                break;
            }
        }
        if (win) return s;

        // Check anti-diagonal
        win = true;
        for (int i = 0; i < n; i++) {
            if (grid.get(i).get(n - 1 - i) != s) {
                win = false;
                break;
            }
        }
        if (win) return s;

        return Symbol.EMPTY; // or null if you prefer
    }
}