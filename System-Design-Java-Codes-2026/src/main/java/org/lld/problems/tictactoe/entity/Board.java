package org.lld.problems.tictactoe.entity;

import org.lld.problems.tictactoe.enums.Symbol;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    List<List<Symbol>> grid;
    Symbol mt;

    public Board(int size) {
        this.size = size;
        mt = Symbol.EMPTY;

        grid = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Symbol> temp = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                temp.add(mt);
            }
            grid.add(temp);
        }
    }

    public int getSize() {
        return size;
    }

    public List<List<Symbol>> getGrid() {
        return grid;
    }

    public Symbol getMt() {
        return mt;
    }

    public boolean validateCell(int x, int y) {
        if (x < 0 || y < 0 || x >= size || y >= size) return false;
        return true;
    }

    public void viewBoard() {
        int n = size;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + grid.get(i).get(j).getValue() + " ");

                if (j != n - 1) {
                    System.out.print("|");
                }
            }

            System.out.println();

            if (i != n - 1) {
                for (int j = 0; j < n; j++) {
                    System.out.print("-----");
                }
                System.out.println();
            }
        }
    }

    public boolean isPositionEmpty(int x, int y) {
        if (!validateCell(x, y)) return false;
        return grid.get(x).get(y) == mt;
    }

    public Symbol getPosition(int x, int y) {
        if (!validateCell(x, y)) return Symbol.EMPTY;
        return grid.get(x).get(y);
    }

    public void placeSymbol(int x, int y, Symbol s) {
        grid.get(x).set(y, s);
    }

    public boolean anyPositionEmpty() {
        for (List<Symbol> oll : grid) {
            for (Symbol s : oll) {
                if (s == Symbol.EMPTY) return true;
            }
        }
        return false;
    }
}