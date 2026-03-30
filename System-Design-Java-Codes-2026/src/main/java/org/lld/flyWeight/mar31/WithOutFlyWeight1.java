package org.lld.flyWeight.mar31;


import java.util.ArrayList;
import java.util.List;

class Asteroid1 {
    // Intrinsic properties (same for many Asteroid1s) - DUPLICATED FOR EACH OBJECT
    private int length;
    private int width;
    private int weight;
    private String color;
    private String texture;
    private String material;

    // Extrinsic properties (unique for each Asteroid1)
    private int posX, posY;
    private int velocityX, velocityY;

    public Asteroid1(int l, int w, int wt, String col, String tex,
                     String mat, int posX, int posY, int velX, int velY) {
        this.length = l;
        this.width = w;
        this.weight = wt;
        this.color = col;
        this.texture = tex;
        this.material = mat;
        this.posX = posX;
        this.posY = posY;
        this.velocityX = velX;
        this.velocityY = velY;
    }

    public void render() {
        System.out.println("Rendering " + color + ", " + texture + ", " + material
                + " Asteroid1 at (" + posX + "," + posY
                + ") Size: " + length + "x" + width
                + " Velocity: (" + velocityX + ", "
                + velocityY + ")");
    }

    // Calculate approximate memory usage per object
    public static long getMemoryUsage() {
        return Integer.BYTES * 7 +                // length, width, weight, x, y, velocityX, velocityY
                40 * 3;                            // Approximate string data (assuming average 10 chars each)
    }
}

class SpaceGame2 {
    private List<Asteroid1> Asteroid1s = new ArrayList<>();

    public void spawnAsteroid1s(int count) {
        System.out.println("\n=== Spawning " + count + " Asteroid1s ===");

        String[] colors = {"Red", "Blue", "Gray"};
        String[] textures = {"Rocky", "Metallic", "Icy"};
        String[] materials = {"Iron", "Stone", "Ice"};
        int[] sizes = {25, 35, 45};

        for (int i = 0; i < count; i++) {
            int type = i % 3;

            Asteroid1s.add(new Asteroid1(
                    sizes[type], sizes[type], sizes[type] * 10,
                    colors[type], textures[type], materials[type],
                    100 + i * 50,         // Simple x: 100, 150, 200, 250...
                    200 + i * 30,         // Simple y: 200, 230, 260, 290...
                    1,                    // All move right with velocity 1
                    2                     // All move down with velocity 2
            ));
        }

        System.out.println("Created " + Asteroid1s.size() + " Asteroid1 objects");
    }

    public void renderAll() {
        System.out.println("\n--- Rendering first 5 Asteroid1s ---");
        for (int i = 0; i < Math.min(5, Asteroid1s.size()); i++) {
            Asteroid1s.get(i).render();
        }
    }

    public long calculateMemoryUsage() {
        return Asteroid1s.size() * Asteroid1.getMemoryUsage();
    }

    public int getAsteroid1Count() {
        return Asteroid1s.size();
    }
}

public class WithOutFlyWeight1 {
    public static void main(String[] args) {
        final int Asteroid1_COUNT = 1_000_000;

        System.out.println("\n TESTING WITHOUT FLYWEIGHT PATTERN");
        SpaceGame2 game = new SpaceGame2();

        game.spawnAsteroid1s(Asteroid1_COUNT);

        // Show first 5 Asteroid1s to see the pattern
        game.renderAll();

        // Calculate and display memory usage
        long totalMemory = game.calculateMemoryUsage();

        System.out.println("\n=== MEMORY USAGE ===");
        System.out.println("Total Asteroid1s: " + Asteroid1_COUNT);
        System.out.println("Memory per Asteroid1: " + Asteroid1.getMemoryUsage() + " bytes");
        System.out.println("Total memory used: " + totalMemory + " bytes");
        System.out.println("Memory in MB: " + totalMemory / (1024.0 * 1024.0) + " MB");
    }
}