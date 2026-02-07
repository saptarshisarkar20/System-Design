package FactoryPattern;

public class Factory {

    public Shape getShape(String sp) {
        return switch (sp) {
            case "TRI" -> new Triangle();
            case "REC" -> new Rectangle();
            default -> null;
        };
    }
}