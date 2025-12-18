package patterns.adapter;

public class CurrencyAdapterFactory {
    public static ICurrencyAdapter getAdapter(String currencyCode) {
        switch (currencyCode.toUpperCase()) {
            case "EUR": return new EURCurrencyAdapter();
            case "EGP": return new EGPCurrencyAdapter();
            case "USD":
            default: return new USDCurrencyAdapter();
        }
    }
}
