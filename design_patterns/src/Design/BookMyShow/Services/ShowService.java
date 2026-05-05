package Design.BookMyShow.Services;

import Design.BookMyShow.entities.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShowService {
    public Map<Integer, Show> shows;
    public Map<Integer, List<Show>> cityToShow;

    public ShowService(){
        this.shows = new HashMap<>();
        this.cityToShow = new HashMap<>();
    }

    public void addShow(int id, Cinema cinema, Movie movie, LocalDateTime startTime, City city, Screen screen){
        Show newShow = new Show(id, startTime, city, movie,cinema, screen);
        shows.put(id, newShow);
        cityToShow.putIfAbsent(city.getId(), new ArrayList<>());
        cityToShow.get(city.getId()).add(newShow);
    }

    public Show getShow(int id){
        return shows.get(id);
    }

    public Show getShowByCityAndMovie(City city, Movie movie){
       return cityToShow.get(city.getId()).stream().filter(s->(s.getMovie().equals(movie))).findFirst().orElse(null);
    }

    public List<Show> getShowByCity(City city){
        return cityToShow.get(city.getId());
    }
}
