package bases;

public abstract class BaseDrink {
    private int milk = 12;
    private int water = 2;
    private int coffee = 18;
    private int cup = 6;
    private int heating = 1;
    private int ice = 3;

    public abstract int getCost();

    public abstract String getDesc();

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getCoffee() {
        return coffee;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public int getCup() {
        return cup;
    }

    public void setCup(int cup) {
        this.cup = cup;
    }

    public int getHeating() {
        return heating;
    }

    public void setHeating(int heating) {
        this.heating = heating;
    }

    public int getIce() {
        return ice;
    }

    public void setIce(int ice) {
        this.ice = ice;
    }
}