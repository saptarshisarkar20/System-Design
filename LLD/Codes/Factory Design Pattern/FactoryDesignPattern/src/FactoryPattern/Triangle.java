package FactoryPattern;

public class Triangle implements Shape {

    @Override
    public void printSides() {
        System.out.println("Triangle has 3 sides");
    }
}