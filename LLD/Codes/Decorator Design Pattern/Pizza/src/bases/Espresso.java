package bases;

public class Espresso extends BaseDrink{
    @Override
    public int getCost() {
        return super.getCoffee() + super.getWater() + super.getHeating() + super.getCup() + 30;
    }

    @Override
    public String getDesc() {
        return "This is an Espresso";
    }
}