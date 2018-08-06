package sodaMachine;


public class DrinkStatus {

    private SodaNames boughtDrink;
    private double balanceAfterDrink;

    public DrinkStatus(SodaNames boughtDrink, double balanceAfterDrink) {
        this.boughtDrink = boughtDrink;
        this.balanceAfterDrink = balanceAfterDrink;
    }

    public SodaNames getBoughtDrink() {
        return boughtDrink;
    }

    public void setBoughtDrink(SodaNames boughtDrink) {
        this.boughtDrink = boughtDrink;
    }

    public double getBalanceAfterDrink() {
        return balanceAfterDrink;
    }

    public void setBalanceAfterDrink(double balanceAfterDrink) {
        this.balanceAfterDrink = balanceAfterDrink;
    }
}
