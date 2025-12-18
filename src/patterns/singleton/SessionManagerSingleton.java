package patterns.singleton;

import java.util.*;

public class SessionManagerSingleton {
    private static final SessionManagerSingleton INSTANCE = new SessionManagerSingleton();
    private final Map<String, String> users = new HashMap<>(); // username -> password
    private final Set<String> authenticated = new HashSet<>();
    private final Map<String, Double> userBalance = new HashMap<>();
    private final Map<String, String> userCurrency = new HashMap<>(); // username -> currency code (USD, EUR, EGP)

    private SessionManagerSingleton() {
        // Empty constructor - users initialized in HardcodedData
    }

    public static SessionManagerSingleton getInstance() { return INSTANCE; }

    public boolean login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            authenticated.add(username);
            return true;
        }
        return false;
    }

    public void logout(String username) { authenticated.remove(username); }

    public boolean isAuthenticated(String username) { return authenticated.contains(username); }

    // allow new user registration
    public boolean register(String username, String password) {
        if (users.containsKey(username)) return false;
        users.put(username, password);
        userBalance.put(username, 100.0);
        userCurrency.put(username, "USD");
        return true;
    }

    public double getBalance(String username) {
        return userBalance.getOrDefault(username, 0.0);
    }

    public String getCurrency(String username) {
        return userCurrency.getOrDefault(username, "USD");
    }

    public void setBalance(String username, double balance) {
        userBalance.put(username, balance);
    }

    public void setCurrency(String username, String currency) {
        userCurrency.put(username, currency);
    }

    public boolean deductBalance(String username, double amount) {
        double current = getBalance(username);
        if (current >= amount) {
            setBalance(username, current - amount);
            return true;
        }
        return false;
    }
}
