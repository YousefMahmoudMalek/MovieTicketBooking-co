package patterns.proxy;

import model.IBooking;
import model.Show;
import patterns.prototype.TicketPrototype;
import patterns.singleton.SessionManagerSingleton;
import patterns.singleton.BookingSystemSingleton;
import java.util.List;

public class BookingProxyPattern implements IBooking {
    private final BookingSystemSingleton realBooking = BookingSystemSingleton.getInstance();

    @Override
    public boolean reserveTempTickets(String username, Show show, List<TicketPrototype> tickets) {
        if (!SessionManagerSingleton.getInstance().isAuthenticated(username)) {
            System.out.println("User not authenticated!");
            return false;
        }
        // Temporary seat reservation
        for (TicketPrototype t : tickets) {
            if (!show.reserveSeat(t.getRow(), t.getCol())) return false;
        }
        return true;
    }

    @Override
    public void confirmBooking(String username, Show show, List<TicketPrototype> tickets) {
        if (!SessionManagerSingleton.getInstance().isAuthenticated(username)) return;
        for (TicketPrototype t : tickets) show.confirmSeat(t.getRow(), t.getCol());
    }

    @Override
    public void releaseReservedTickets(String username, Show show, List<TicketPrototype> tickets) {
        if (!SessionManagerSingleton.getInstance().isAuthenticated(username)) return;
        for (TicketPrototype t : tickets) {
            show.releaseSeat(t.getRow(), t.getCol());
        }
    }
}
