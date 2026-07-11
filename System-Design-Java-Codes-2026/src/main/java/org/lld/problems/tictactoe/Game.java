package org.lld.problems.tictactoe;

import org.lld.problems.tictactoe.entity.Board;
import org.lld.problems.tictactoe.entity.Player;
import org.lld.problems.tictactoe.entity.Rules;
import org.lld.problems.tictactoe.enums.GameType;
import org.lld.problems.tictactoe.enums.Symbol;
import org.lld.problems.tictactoe.factory.GameFactory;
import org.lld.problems.tictactoe.observer.ConsoleGameObserver;
import org.lld.problems.tictactoe.observer.GameObserver;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    Board board;
    ArrayDeque<Player> players;
    Rules rules;
    List<GameObserver> observers; // will add later
    boolean gameOver;

    public Game(Board board, Rules rules) {
        this.board = board;
        gameOver = false;
        players = new ArrayDeque<>();
        this.rules = rules;
        observers = new ArrayList<>();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== TIC TAC TOE =====");

        System.out.print("Board Size : ");

        int size = sc.nextInt();

        sc.nextLine();

        Game game = GameFactory.createGame(GameType.STANDARD, size);

        System.out.print("Player 1 Name : ");

        Player p1 = new Player(sc.nextLine(), Symbol.X);

        System.out.print("Player 2 Name : ");

        Player p2 = new Player(sc.nextLine(), Symbol.O);

        game.addPlayers(p1);
        game.addPlayers(p2);

        game.addObserver(new ConsoleGameObserver());

        game.start();
    }

    public void addPlayers(Player player) {
        players.add(player);
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    private void notifyMove(Player p, int x, int y) {
        observers.forEach(o -> o.onMove(this, p, x, y));
    }

    private void notifyWinner(Player p) {
        observers.forEach(o -> o.onGameWon(this, p));
    }

    private void notifyDraw() {
        observers.forEach(o -> o.onGameDraw(this));
    }

    public void start() {

        Scanner sc = new Scanner(System.in);

        while (!gameOver) {

            Player current = players.pollFirst();

            board.viewBoard();

            System.out.println(current.getDetails());
            System.out.print("Enter row : ");

            int x = sc.nextInt();

            System.out.print("Enter col : ");

            int y = sc.nextInt();

            if (!rules.isValidMove(board, x, y)) {
                System.out.println("Invalid Move.");
                players.addFirst(current);
                continue;
            }

            board.placeSymbol(x, y, current.s);

            notifyMove(current, x, y);

            if (rules.isWin(board, current.s) != Symbol.EMPTY) {

                current.incrementScore();

                board.viewBoard();

                notifyWinner(current);

                gameOver = true;

                break;
            }

            if (rules.isDraw(board)) {

                board.viewBoard();

                notifyDraw();

                gameOver = true;

                break;
            }

            players.offerLast(current);
        }
    }
}