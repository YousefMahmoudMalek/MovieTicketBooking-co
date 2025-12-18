package patterns.adapter;

public class EGPCurrencyAdapter implements ICurrencyAdapter {
    private static final double EGP_TO_USD = 0.032; // 1 EGP = 0.032 USD (simulated rate)

    @Override
    public double convertToUSD(double amount) {
        // Convert from EGP to USD
        return amount * EGP_TO_USD;
    }

    @Override
    public double convertFromUSD(double amount) {
        // Convert from USD to EGP
        return amount / EGP_TO_USD;
    }

    @Override
    public String getCurrencyCode() {
        return "EGP";
    }
}
