package UI;

import patterns.singleton.BookingSystemSingleton;

/**
 *
 * @author abdelaziz
 */
public class MovieTicketBooking {
    public static void main(String[] args) {
       BookingSystemSingleton.getInstance();
       
       LoginFrame login = new LoginFrame();
       login.setVisible(true);
       login.setResizable(false);
    }
}
