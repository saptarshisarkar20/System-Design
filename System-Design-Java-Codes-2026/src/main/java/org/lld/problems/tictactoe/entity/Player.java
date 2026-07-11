package org.lld.problems.tictactoe.entity;

import org.lld.problems.tictactoe.enums.Symbol;

import java.util.UUID;

public class Player {
    public Symbol s;
    String id;
    String name;
    int score;

    public Player(String name, Symbol s) {
        this.name = name;
        this.s = s;
        this.id = UUID.randomUUID().toString().replace("-", "");
        score = 0;
    }

    public void incrementScore() {
        score += 1;
    }


    public String getDetails() {
        return "Player{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", s=" + s +
                ", score=" + score +
                '}';
    }
}