package bases;

public class Decaf extends BaseDrink{
    @Override
    public int getCost() {
        return super.getCoffee() + super.getWater()+super.getMilk() + super.getHeating() + super.getCup() + 40;
    }

    @Override
    public String getDesc() {
        return "This is an Decaf";
    }
}