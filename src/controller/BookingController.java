package controller;

import model.IBooking;
import model.Show;
import patterns.prototype.TicketPrototype;
import patterns.singleton.BookingSystemSingleton;
import patterns.proxy.BookingProxyPattern;
import patterns.singleton.SessionManagerSingleton;
import patterns.adapter.ICurrencyAdapter;
import patterns.adapter.CurrencyAdapterFactory;
import java.util.ArrayList;
import java.util.List;

public class BookingController {
    private IBooking booking = new BookingProxyPattern(); // proxy wraps BookingSystem

    public List<Show> searchShowsByGenre(String genre) {
        return BookingSystemSingleton.getInstance().searchShows(genre);
    }

    public boolean reserveTickets(String username, Show show, List<int[]> seats) {
        // Calculate total price in USD
        double totalPriceUSD = show.getPrice() * seats.size();
        
        String userCurrency = SessionManagerSingleton.getInstance().getCurrency(username);
        ICurrencyAdapter currencyAdapter = CurrencyAdapterFactory.getAdapter(userCurrency);
        
        double priceInUserCurrency = currencyAdapter.convertFromUSD(totalPriceUSD);
        
        double userBalance = SessionManagerSingleton.getInstance().getBalance(username);
        if (userBalance < priceInUserCurrency) {
            System.out.println("Insufficient balance. Need " + priceInUserCurrency + " " + userCurrency + ", but have " + userBalance + " " + userCurrency);
            return false;
        }
        
        // create tickets via prototype
        List<TicketPrototype> tickets = new ArrayList<>();
        for (int[] s : seats) {
            TicketPrototype template = new TicketPrototype(show.getMovie().getTitle(), show, s[0], s[1], show.getPrice());
            tickets.add(template.cloneTicket());
        }
        boolean reserved = booking.reserveTempTickets(username, show, tickets);
        if (!reserved) return false;
        
        SessionManagerSingleton.getInstance().deductBalance(username, priceInUserCurrency);
        
        booking.confirmBooking(username, show, tickets);
        System.out.println("Payment successful: " + priceInUserCurrency + " " + userCurrency + " deducted. Remaining balance: " + SessionManagerSingleton.getInstance().getBalance(username) + " " + userCurrency);
        return true;
    }
}
