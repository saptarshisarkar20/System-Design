package org.lld.flyWeight.mar31;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Asteroid {
    // Intrinsic properties (same for many asteroids) - DUPLICATED FOR EACH OBJECT
    private int length;
    private int width;
    private int weight;
    private String color;
    private String texture;
    private String material;

//    // Extrinsic properties (unique for each asteroid)
//    private int posX, posY;
//    private int velocityX, velocityY;

    Asteroid(int l, int w, int wt, String col, String tex, String mat) {
        this.length = l;
        this.width = w;
        this.weight = wt;
        this.color = col;
        this.texture = tex;
        this.material = mat;
    }

    void render(int posX, int posY, int velX, int velY) {
        System.out.println("Rendering " + color + ", " + texture + ", " + material
                + " asteroid at (" + posX + "," + posY
                + ") Size: " + length + "x" + width
                + " Velocity: (" + velX + ", "
                + velY + ")");
    }

    // Calculate approximate memory usage per object
    static long getMemoryUsage() {
        return Integer.BYTES * 3 +                // length, width, weight
                40 * 3;                            // Approximate string data (assuming average 10 chars each)
    }
}

class AsteroidFactory {
    static Map<String, Asteroid> asteroidMap = new HashMap<>();


    static Asteroid findAsteroid(int l, int w, int wt, String col, String tex, String mat) {
        String key = l + "|" + w + "|" + wt + "|" + col + "|" + tex + "|" + mat;
        if (!asteroidMap.containsKey(key)) {
            asteroidMap.put(key, new Asteroid(l, w, wt, col, tex, mat));
        }
        return asteroidMap.get(key);
    }

    static int getFlyweightCount() {
        return asteroidMap.size();
    }

    static long getTotalFlyweightMemory() {
        return asteroidMap.size() * Asteroid.getMemoryUsage();
    }

    static void cleanup() {
        asteroidMap.clear();
    }

}

class AsteroidContext {

    private Asteroid asteroid;
    private int posX, posY;
    private int velocityX, velocityY;

    AsteroidContext(Asteroid fw, int posX, int posY, int velX, int velY) {
        this.asteroid = fw;
        this.posX = posX;
        this.posY = posY;
        this.velocityX = velX;
        this.velocityY = velY;
    }

    void render() {
        asteroid.render(posX, posY, velocityX, velocityY);
    }

    static long getMemoryUsage() {
        return 8 + Integer.BYTES * 4; // approximate pointer + ints
    }

}


class SpaceGame {
    private List<AsteroidContext> asteroids = new ArrayList<>();

    public void spawnAsteroids(int count) {
        System.out.println("\n=== Spawning " + count + " asteroids ===");

        String[] colors = {"Red", "Blue", "Gray"};
        String[] textures = {"Rocky", "Metallic", "Icy"};
        String[] materials = {"Iron", "Stone", "Ice"};
        int[] sizes = {25, 35, 45};

        for (int i = 0; i < count; i++) {
            int type = i % 3;

            asteroids.add(new AsteroidContext(AsteroidFactory.findAsteroid(
                    sizes[type], sizes[type], sizes[type] * 10,
                    colors[type], textures[type], materials[type]),
                    100 + i * 50,         // Simple x: 100, 150, 200, 250...
                    200 + i * 30,         // Simple y: 200, 230, 260, 290...
                    1,                    // All move right with velocity 1
                    2                     // All move down with velocity 2
            ));
        }

        System.out.println("Created " + asteroids.size() + " asteroid objects");
    }

    public void renderAll() {
        System.out.println("\n--- Rendering first 5 asteroids ---");
        for (int i = 0; i < Math.min(5, asteroids.size()); i++) {
            asteroids.get(i).render();
        }
    }

    public long calculateMemoryUsage() {
        long contextMemory = asteroids.size() * AsteroidContext.getMemoryUsage();
        long flyweightMemory = AsteroidFactory.getTotalFlyweightMemory();
        return contextMemory + flyweightMemory;
    }

    public int getAsteroidCount() {
        return asteroids.size();
    }
}

public class FlyWeight1 {
    public static void main(String[] args) {
        final int ASTEROID_COUNT = 1_000_000;

        System.out.println("\n TESTING WITHOUT FLYWEIGHT PATTERN");
        SpaceGame game = new SpaceGame();

        game.spawnAsteroids(ASTEROID_COUNT);

        // Show first 5 asteroids to see the pattern
        game.renderAll();

        // Calculate and display memory usage
        long totalMemory = game.calculateMemoryUsage();

        System.out.println("\n=== MEMORY USAGE ===");
        System.out.println("Total asteroids: " + ASTEROID_COUNT);
        System.out.println("Memory per asteroid: " + Asteroid.getMemoryUsage() + " bytes");
        System.out.println("Total memory used: " + totalMemory + " bytes");
        System.out.println("Memory in MB: " + totalMemory / (1024.0 * 1024.0) + " MB");
    }
}