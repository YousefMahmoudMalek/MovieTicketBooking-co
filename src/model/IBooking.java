package model;

import patterns.prototype.TicketPrototype;
import java.util.List;

public interface IBooking {
    boolean reserveTempTickets(String user, Show show, List<TicketPrototype> tickets);
    void confirmBooking(String user, Show show, List<TicketPrototype> tickets);
    void releaseReservedTickets(String user, Show show, List<TicketPrototype> tickets);
}
