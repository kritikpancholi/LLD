package Design.HotelBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    public List<Room> rooms;
    public List<Booking> booking;

    public  Hotel(){
        this.rooms = new ArrayList<>();
        this.booking = new ArrayList<>();
    }

    public Room getRoom(String roomNumber){
        return rooms.stream().filter(room-> room.getRoomNumber().equals(roomNumber)).findFirst().orElse(null);
    }

    public void createRoom(String roomNumber, RoomType roomType, int price){
        rooms.add(new Room(roomType,roomNumber,price));
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void addBooking(Booking newBooking){
        booking.add(newBooking);
    }

    public Guest createGuest(String id, String name, String mob){
        return new Guest(id, name, mob);
    }

}
