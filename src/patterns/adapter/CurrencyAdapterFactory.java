package patterns.adapter;

public class CurrencyAdapterFactory {
    public static ICurrencyAdapter getAdapter(String currencyCode) {
        switch (currencyCode.toUpperCase()) {
            case "EUR": return new EURCurrencyAdapter();
            case "GBP": return new GBPCurrencyAdapter();
            case "USD":
            default: return new USDCurrencyAdapter();
        }
    }
}
