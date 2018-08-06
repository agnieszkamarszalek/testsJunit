package sodaMachine;

public enum SodaNames {
    COKE("Coke", 1.00),
    SPRITE("Sprite", 2.00),
    WATER("Water", 4.00),
    BEER("Beer", 3.00);

    String sodaName;
    double price;

    SodaNames(String sodaName, double price) {
        this.sodaName = sodaName.toUpperCase();
        this.price = price;
    }

    public String getSodaName() {
        return sodaName;
    }

    public double getPrice() {
        return price;
    }
}
