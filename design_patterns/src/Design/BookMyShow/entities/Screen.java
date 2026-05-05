package Design.BookMyShow.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Screen {

    public int id;
    public Map<Integer, Seat> seats;

    public Screen(int id){
        this.id = id;
        this.seats = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public Map<Integer, Seat> getSeats(){
        return this.seats;
    }

    public Seat getSeat(int seatId) {
        return seats.get(seatId);
    }

    public void addSeat(Seat seat){
        seats.put(seat.id, seat);
    }

}
