package patterns.prototype;

import model.Show;

public class TicketPrototype implements Cloneable {
    private final String movieTitle;
    private final Show show;
    private final int row;
    private final int col;
    private final double price;

    public TicketPrototype(String movieTitle, Show show, int row, int col, double price) {
        this.movieTitle = movieTitle;
        this.show = show;
        this.row = row;
        this.col = col;
        this.price = price;
    }

    public String getMovieTitle() { return movieTitle; }
    public Show getShow() { return show; }
    public int getRow() { return row; }
    public int getCol() { return col; }
    public double getPrice() { return price; }

    public TicketPrototype cloneTicket() {
        try {
            return (TicketPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            return new TicketPrototype(movieTitle, show, row, col, price);
        }
    }
}
