package Design.HotelBookingSystem;

import java.time.LocalDateTime;

public class Room {

    final RoomType roomType;
    public String roomNumber;
    final int price;

    public Room( RoomType roomType, String roomNumber, int price){
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.price = price;
    }

    public String getRoomNumber(){
        return roomNumber;
    }

    public int getPrice(){
        return price;
    }

    public RoomType getRoomType() {
        return roomType;
    }
}
