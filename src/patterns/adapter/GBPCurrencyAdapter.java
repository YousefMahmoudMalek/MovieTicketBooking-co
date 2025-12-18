package patterns.adapter;

public class GBPCurrencyAdapter implements ICurrencyAdapter {
    private static final double GBP_TO_USD = 1.27; // 1 GBP = 1.27 USD (simulated rate)

    @Override
    public double convertToUSD(double amount) {
        return amount * GBP_TO_USD;
    }

    @Override
    public double convertFromUSD(double amount) {
        return amount / GBP_TO_USD;
    }

    @Override
    public String getCurrencyCode() {
        return "GBP";
    }
}
