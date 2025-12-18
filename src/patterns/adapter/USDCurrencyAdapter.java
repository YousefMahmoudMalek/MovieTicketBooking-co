package patterns.adapter;

public class USDCurrencyAdapter implements ICurrencyAdapter {
    @Override
    public double convertToUSD(double amount) {
        return amount; // Already in USD
    }

    @Override
    public double convertFromUSD(double amount) {
        return amount; // Already in USD
    }

    @Override
    public String getCurrencyCode() {
        return "USD";
    }
}
