package addOnes;

import bases.BaseDrink;

public class Mocha extends BaseAddon {
    private BaseDrink baseDrink;
    private int mocaCost = 43;

    public Mocha(BaseDrink baseDrink) {
        this.baseDrink = baseDrink;
    }

    @Override
    public int getCost() {
        return baseDrink.getCost() + mocaCost;
    }

    @Override
    public String getDesc() {
        return baseDrink.getDesc() + " + Mocha";
    }
}