package patterns.adapter;

public class EURCurrencyAdapter implements ICurrencyAdapter {
    private static final double EUR_TO_USD = 1.10; // 1 EUR = 1.10 USD (simulated rate)

    @Override
    public double convertToUSD(double amount) {
        return amount * EUR_TO_USD;
    }

    @Override
    public double convertFromUSD(double amount) {
        return amount / EUR_TO_USD;
    }

    @Override
    public String getCurrencyCode() {
        return "EUR";
    }
}
