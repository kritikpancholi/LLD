package Design.BookMyShow.entities;


import java.util.HashMap;
import java.util.Map;

public class Cinema {

    public int id;
    public String theaterName;
    public Map<Integer, Screen> screens;


    public Cinema(int id, String theaterName){
        this.id = id;
        this.theaterName = theaterName;
        this.screens = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void addScreen(Screen newScreen){
        this.screens.put(newScreen.getId(), newScreen);
    }

}
