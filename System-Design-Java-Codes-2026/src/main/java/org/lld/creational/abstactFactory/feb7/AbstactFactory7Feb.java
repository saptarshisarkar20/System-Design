package org.lld.creational.abstactFactory.feb7;

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

abstract class GarlicBread {
    abstract void prepGB();
}

class PlainGB extends GarlicBread {

    @Override
    void prepGB() {
        System.out.println("plain garlic bread");
    }
}

class FilledGB extends GarlicBread {

    @Override
    void prepGB() {
        System.out.println("filled garlic bread");
    }
}

class PlainWheatGB extends GarlicBread {

    @Override
    void prepGB() {
        System.out.println("plain wheat garlic bread");
    }
}

class FilledWheatGB extends GarlicBread {

    @Override
    void prepGB() {
        System.out.println("filled wheat garlic bread");
    }
}

abstract class ResturantFactory {
    abstract Pizza getPizza(String type);

    abstract GarlicBread getGB(String type);
}

class DomPizzaFactory extends ResturantFactory {
    @Override
    Pizza getPizza(String type) {
        return switch (type) {
            case "small" -> new SmallPizza();
            case "mid" -> new MidPizza();
            case "large" -> new LargePizza();
            default -> null;
        };
    }

    @Override
    GarlicBread getGB(String type) {
        return switch (type) {
            case "plain" -> new PlainGB();
            case "filled" -> new FilledGB();
            default -> null;
        };
    }
}

class HutPizzaFactory extends ResturantFactory {
    @Override
    Pizza getPizza(String type) {
        return switch (type) {
            case "small" -> new SmallWheatPizza();
            case "mid" -> new MidWheatPizza();
            case "large" -> new LargeWheatPizza();
            default -> null;
        };
    }

    @Override
    GarlicBread getGB(String type) {
        return switch (type) {
            case "plain" -> new PlainWheatGB();
            case "filled" -> new FilledWheatGB();
            default -> null;
        };
    }
}

public class AbstactFactory7Feb {
    public static void main(String[] args) {
        ResturantFactory dd = new DomPizzaFactory();
        dd.getPizza("mid").prepPizza();
        dd.getGB("filled").prepGB();

        ResturantFactory hh = new HutPizzaFactory();
        hh.getPizza("large").prepPizza();
        hh.getGB("plain").prepGB();

    }

}