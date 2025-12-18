package patterns.singleton;

import model.Show;
import util.HardcodedData;
import java.util.*;
import java.util.stream.Collectors;

public class BookingSystemSingleton {
    private static final BookingSystemSingleton INSTANCE = new BookingSystemSingleton();
    private List<Show> shows;

    private BookingSystemSingleton() {
        shows = HardcodedData.createSampleShows();
    }

    public static BookingSystemSingleton getInstance() { return INSTANCE; }

    public List<Show> getAllShows() { return shows; }

    public List<Show> searchShows(String genre) {
        return shows.stream()
                .filter(s -> s.getMovie().getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }
}
