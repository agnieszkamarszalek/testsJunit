package sodaMachine;

public class SodaMachine {

    public double sell(double price, double balance) {
        double result = 0;
        if(price <= balance) {
            result = balance - price;
        }else {
            result = balance;
        }
        return result;
    }

    public String payAndGetSoda(double price, double balance) {
        //switch (SodaNames.valueOf())
        if(price == 1) return SodaNames.COKE.getSodaName();
        else if(price == 2) return SodaNames.SPRITE.getSodaName();
        else if(price == 3) return SodaNames.BEER.getSodaName();
        else if(price == 4) return SodaNames.WATER.getSodaName();
        return "";
    }

    public DrinkStatus sell(String types, double balance) {
        double sodaPrice = SodaNames.valueOf(types.toUpperCase()).getPrice();
        SodaNames sodaNames = SodaNames.valueOf(types.toUpperCase());
        double balanceAfterBuy = balance - sodaPrice;

        return new DrinkStatus(sodaNames, balanceAfterBuy);
    }
}
