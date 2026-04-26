package Design.HotelBookingSystem;

import java.time.LocalDate;

public class HotelDriver {

    public void run(){

        Hotel hotel = new Hotel();
        hotel.createRoom("101", RoomType.SINGLE, 1200);
        hotel.createRoom("102", RoomType.DOUBLE, 1500);
        hotel.createRoom("201", RoomType.DOUBLE, 1500);
        Guest guest1 = hotel.createGuest("1", "Ram", "000");
        Guest guest2 = hotel.createGuest("2", "Sham", "001");
        HotelManager hotelManager = new HotelManager(hotel);
        LocalDate checkin1 = LocalDate.of(2026, 4, 26);
        LocalDate checkout1 = LocalDate.of(2026, 4, 28);


        hotelManager.bookRoom(guest1, RoomType.SINGLE, checkin1, checkout1);

        // will return room not available
        hotelManager.bookRoom(guest2, RoomType.SINGLE, LocalDate.of(2026,4,27) , LocalDate.of(2026,4,28) );
//        hotelManager.bookRoom(guest2, RoomType.DOUBLE, );

        hotelManager.bookRoom(guest2, RoomType.DOUBLE, LocalDate.of(2026,4,27) , LocalDate.of(2026,4,28) );

        hotelManager.bookRoom(guest1, RoomType.DOUBLE, LocalDate.of(2026,4,28), LocalDate.of(2026,4,29));

    }

}
