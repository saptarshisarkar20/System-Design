package addOnes;

import bases.BaseDrink;

public class Whip extends BaseAddon{
    private BaseDrink baseDrink;
    private int whipCost = 26;

    public Whip(BaseDrink baseDrink) {
        this.baseDrink = baseDrink;
    }

    @Override
    public int getCost() {
        return baseDrink.getCost() + whipCost;
    }

    @Override
    public String getDesc() {
        return baseDrink.getDesc() + " + Whip Cream";
    }
}