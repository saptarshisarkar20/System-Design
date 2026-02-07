package bases;

public class Frappe extends BaseDrink {
    @Override
    public int getCost() {
        return super.getCoffee() + super.getWater() + super.getCup()
                + super.getIce() + super.getMilk() + 100;
    }

    @Override
    public String getDesc() {
        return "This is an Frappe";
    }
}