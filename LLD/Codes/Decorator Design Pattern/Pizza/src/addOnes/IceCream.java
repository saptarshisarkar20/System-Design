package addOnes;

import bases.BaseDrink;

public class IceCream extends BaseAddon{
    private BaseDrink baseDrink;
    private int icCost = 130;

    public IceCream(BaseDrink baseDrink) {
        this.baseDrink = baseDrink;
    }

    @Override
    public int getCost() {
        return baseDrink.getCost() + icCost;
    }

    @Override
    public String getDesc() {
        return baseDrink.getDesc() + " + IceCream";
    }
}