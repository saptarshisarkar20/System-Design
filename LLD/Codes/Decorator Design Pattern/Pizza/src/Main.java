import addOnes.BaseAddon;
import addOnes.IceCream;
import addOnes.Mocha;
import addOnes.Whip;
import bases.BaseDrink;
import bases.Decaf;
import bases.Espresso;
import bases.Frappe;
import jdk.jfr.Frequency;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//        1st order

        BaseDrink o1 = new Whip(new Mocha(new Espresso()));
        System.out.print(o1.getDesc() + " : ");
        System.out.println(o1.getCost());

        //        2nd order
        BaseDrink o2 = new IceCream(new Whip(new Frappe()));
        System.out.print(o2.getDesc() + " : ");
        System.out.println(o2.getCost());


        //        3 rd order
        BaseDrink o3 = new Mocha(new Mocha(new Mocha(new IceCream(new IceCream(new Decaf())))));
        System.out.print(o3.getDesc() + " : ");
        System.out.println(o3.getCost());
    }
}