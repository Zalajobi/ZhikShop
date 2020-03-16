package zhikrullah.online.shop.Model.Enums;

public enum ProductCategory {
    Phones_And_Tablets("Phones And Tablets"),
    Computing("Computing"),
    Electronics("Electronics"),
    Home_And_Office("Home And Office"),
    Fashion("Fashion"),
    Health_And_Beauty("Health And Beauty"),
    Gaming("Gaming"),
    Grocery("Grocery"),
    Baby_Products("Baby Products"),
    Car("Car");


    private final String displayValue;

    ProductCategory(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
