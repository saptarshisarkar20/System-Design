package org.lld.problems.tictactoe.observer;

import org.lld.problems.tictactoe.Game;
import org.lld.problems.tictactoe.entity.Player;

public interface GameObserver {
    void onMove(Game game, Player player, int row, int col);

    void onGameWon(Game game, Player winner);

    void onGameDraw(Game game);
}