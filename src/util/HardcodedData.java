package util;

import patterns.builder.ShowBuilder;
import patterns.singleton.SessionManagerSingleton;
import model.Movie;
import model.Show;
import model.Theater;
import patterns.factory.MovieFactory;
import java.util.*;

public class HardcodedData {
    
    public static void initializeUsers() {
        SessionManagerSingleton session1 = SessionManagerSingleton.getInstance();
        SessionManagerSingleton session2 = SessionManagerSingleton.getInstance();
        
        // Both references point to the same instance (demonstrating singleton)
        System.out.println("Singleton check: session1 == session2? " + (session1 == session2));
        
        // Add hardcoded users with different currencies to demonstrate adapter pattern
        session1.register("charlie", "pass3");
        session1.setBalance("charlie", 250.0);
        session1.setCurrency("charlie", "USD");
        
        // Using session2 (same singleton instance) to add more users
        session2.register("diana", "pass4");
        session2.setBalance("diana", 180.0);
        session2.setCurrency("diana", "EUR");
        
        session1.register("eve", "pass5");
        session1.setBalance("eve", 300.0);
        session1.setCurrency("eve", "GBP");
        
        // Verify they're all in the same instance
        System.out.println("Total users via session1: charlie, diana, eve added");
    }
    
    public static List<Show> createSampleShows() {
        initializeUsers();
        
        List<Show> s = new ArrayList<>();
        Movie m1 = MovieFactory.createMovie("Action", "Fast & Busy");
        Movie m2 = MovieFactory.createMovie("Comedy", "Fun Times");
        Show show1 = new ShowBuilder().setMovie(m1).setTheater(new Theater("Hall A")).setTime("18:00").setPrice(10.0).build();
        Show show2 = new ShowBuilder().setMovie(m2).setTheater(new Theater("Hall B")).setTime("20:00").setPrice(8.0).build();
        Movie m3 = MovieFactory.createMovie("Action", "Speed Rush");
        Movie m4 = MovieFactory.createMovie("Comedy", "Laugh Riot");
        Movie m5 = MovieFactory.createMovie("Action", "Chase Forever");
        Movie m6 = MovieFactory.createMovie("Comedy", "Office Antics");
        Movie m7 = MovieFactory.createMovie("Drama", "Life's Journey");
        Movie m8 = MovieFactory.createMovie("Drama", "Silent Tears");
        Show show3 = new ShowBuilder().setMovie(m3).setTheater(new Theater("Hall C")).setTime("16:00").setPrice(11.0).build();
        Show show4 = new ShowBuilder().setMovie(m4).setTheater(new Theater("Hall D")).setTime("21:00").setPrice(9.0).build();
        Show show5 = new ShowBuilder().setMovie(m5).setTheater(new Theater("Hall E")).setTime("19:30").setPrice(12.0).build();
        Show show6 = new ShowBuilder().setMovie(m6).setTheater(new Theater("Hall F")).setTime("22:00").setPrice(7.5).build();
        Show show7 = new ShowBuilder().setMovie(m7).setTheater(new Theater("Hall G")).setTime("17:00").setPrice(9.5).build();
        Show show8 = new ShowBuilder().setMovie(m8).setTheater(new Theater("Hall H")).setTime("22:30").setPrice(10.5).build();
        // preset some reserved seats
        show1.reserveSeat(0,0); // A1
        show1.reserveSeat(2,3);
        show2.reserveSeat(1,1);
        s.add(show1); s.add(show2); s.add(show3); s.add(show4); s.add(show5); s.add(show6); s.add(show7); s.add(show8);
        return s;
    }
}
