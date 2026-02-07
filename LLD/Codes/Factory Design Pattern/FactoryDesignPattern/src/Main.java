import FactoryPattern.Factory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();

        factory.getShape("TRI").printSides();
        factory.getShape("REC").printSides();

    }
}