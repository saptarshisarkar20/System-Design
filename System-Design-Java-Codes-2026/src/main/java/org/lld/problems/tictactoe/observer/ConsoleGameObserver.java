package org.lld.problems.tictactoe.observer;

import org.lld.problems.tictactoe.Game;
import org.lld.problems.tictactoe.entity.Player;

public class ConsoleGameObserver implements GameObserver {
    @Override
    public void onMove(Game game, Player player, int row, int col) {
        System.out.println(player.getDetails() + " played (" + row + "," + col + ")");
    }

    @Override
    public void onGameWon(Game game, Player winner) {
        System.out.println(winner.getDetails() + " WON!");
    }

    @Override
    public void onGameDraw(Game game) {
        System.out.println("Game Draw.");
    }
}