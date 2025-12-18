package patterns.adapter;

public interface ICurrencyAdapter {
    // Convert from user's currency to USD (base currency for ticket prices)
    double convertToUSD(double amount);
    // Convert from USD to user's currency
    double convertFromUSD(double amount);
    String getCurrencyCode();
}
