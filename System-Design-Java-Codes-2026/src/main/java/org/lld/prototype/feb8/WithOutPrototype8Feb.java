package org.lld.prototype.feb8;

// Simple NPC_1 class — no Prototype
class NPC_1 {
    public String name;
    public int health;
    public int attack;
    public int defense;

    // "Heavy" constructor: every field must be provided
    public NPC_1(String name, int health, int attack, int defense) {
        // call database
        // complex calc
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        System.out.println("Creating NPC_1 '" + name + "' [HP:" + health + ", ATK:"
                + attack + ", DEF:" + defense + "]");
    }

    public void describe() {
        System.out.println("  NPC_1: " + name + " | HP=" + health + " ATK=" + attack
                + " DEF=" + defense);
    }
}

public class WithOutPrototype8Feb {
    public static void main(String[] args) {
        // Base Alien
        NPC_1 alien = new NPC_1("Alien", 30, 5, 2);
        alien.describe();

        // Powerful Alien — must re-pass all stats, easy to make mistakes
        NPC_1 alien2 = new NPC_1("Powerful Alien", 30, 5, 5);
        alien2.describe();

        // If you want 100 aliens, you'd repeat this 100 times…
    }
}