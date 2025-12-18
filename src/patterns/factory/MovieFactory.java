package patterns.factory;

import model.Movie;
import patterns.factory.movieTypes.ActionMovie;
import patterns.factory.movieTypes.ComedyMovie;
import patterns.factory.movieTypes.DramaMovie;

public class MovieFactory {
    public static Movie createMovie(String genre, String title) {
        switch (genre.toLowerCase()) {
            case "action": return new ActionMovie(title);
            case "comedy": return new ComedyMovie(title);
            case "drama": return new DramaMovie(title);
            default: return new ActionMovie(title);
        }
    }
}
