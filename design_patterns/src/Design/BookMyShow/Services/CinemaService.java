package Design.BookMyShow.Services;

import Design.BookMyShow.entities.Cinema;
import Design.BookMyShow.entities.NormalSeat;
import Design.BookMyShow.entities.PremiumSeat;
import Design.BookMyShow.entities.Screen;

import java.util.HashMap;
import java.util.Map;

public class CinemaService {

    public Map<Integer, Cinema> cinemaMap;

    public CinemaService(){
        this.cinemaMap = new HashMap<>();
    }

    public void createCinema(int id, String cinemaName){
        cinemaMap.put(id, new Cinema(id, cinemaName));
    }

    public Screen addScreen(int cinemaId, int screenId ,int premiumSeatCount, int normalSeatCount){
        Cinema cinema = cinemaMap.get(cinemaId);
        Screen newScreen = new Screen(screenId);
        cinema.addScreen(newScreen);
        int i = 1;
        for( ;i<=premiumSeatCount;i++){
            newScreen.addSeat(new PremiumSeat(i,500));
        }

        for(;i<=premiumSeatCount+normalSeatCount;i++){
            newScreen.addSeat(new NormalSeat(i,250));
        }
        return newScreen;
    }
    public Cinema getCinema(int id){
        return cinemaMap.get(id);
    }

}
