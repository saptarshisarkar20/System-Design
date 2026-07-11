package org.lld.problems.tictactoe.factory;

import org.lld.problems.tictactoe.Game;
import org.lld.problems.tictactoe.entity.Board;
import org.lld.problems.tictactoe.entity.StandardRules;
import org.lld.problems.tictactoe.enums.GameType;

public class GameFactory {
    public static Game createGame(GameType type, int size) {

        switch (type) {

            case STANDARD:
                return new Game(
                        new Board(size),
                        new StandardRules()
                );

            default:
                throw new IllegalArgumentException("Unsupported Game Type");
        }
    }
}