package Design.BookMyShow.entities;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Show {

    public int id;
    public City city;
    public Movie movie;
    public Cinema cinema;
    public Screen screen;
    public LocalDateTime startTime;

    public Show(int id, LocalDateTime startTime, City city, Movie movie, Cinema cinema, Screen screen){
        this.id = id;
        this.startTime = startTime;
        this.cinema = cinema;
        this.city = city;
        this.movie = movie;
        this.screen = screen;
    }

    public Movie getMovie() {
        return movie;
    }
    public int getId(){
        return id;
    }

    public City getCity() {
        return city;
    }

    public Screen getScreen() {
        return screen;
    }
}
