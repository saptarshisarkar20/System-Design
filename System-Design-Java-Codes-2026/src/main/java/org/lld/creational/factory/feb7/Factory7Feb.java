package org.lld.factory.feb7;

abstract class Pizza {
    abstract void prepPizza();
}

class SmallPizza extends Pizza {

    @Override
    void prepPizza() {
        System.out.println("Small Pizza");
    }
}

class MidPizza extends Pizza {

    @Override
    void prepPizza() {
        System.out.println("Mid Pizza");
    }
}

class LargePizza extends Pizza {

    @Override
    void prepPizza() {
        System.out.println("Large Pizza");
    }
}

class SmallWheatPizza extends Pizza {

    @Override
    void prepPizza() {
        System.out.println("Small Wheat Pizza");
    }
}

class MidWheatPizza extends Pizza {

    @Override
    void prepPizza() {
        System.out.println("Mid Wheat Pizza");
    }
}

class LargeWheatPizza extends Pizza {

    @Override
    void prepPizza() {
        System.out.println("large Wheat Pizza");
    }
}

abstract class PizzaFactory {
    abstract Pizza getPizza(String type);
}

class DomPizzaFactory extends PizzaFactory {
    @Override
    Pizza getPizza(String type) {
        return switch (type) {
            case "small" -> new SmallPizza();
            case "mid" -> new MidPizza();
            case "large" -> new LargePizza();
            default -> null;
        };
    }
}

class HutPizzaFactory extends PizzaFactory {
    @Override
    Pizza getPizza(String type) {
        return switch (type) {
            case "small" -> new SmallWheatPizza();
            case "mid" -> new MidWheatPizza();
            case "large" -> new LargeWheatPizza();
            default -> null;
        };
    }
}

public class Factory7Feb {
    public static void main(String[] args) {
        PizzaFactory dd = new DomPizzaFactory();
        dd.getPizza("mid").prepPizza();

        PizzaFactory hh = new HutPizzaFactory();
        hh.getPizza("large").prepPizza();

    }

}