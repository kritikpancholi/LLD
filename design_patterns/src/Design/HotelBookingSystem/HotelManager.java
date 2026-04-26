package Design.HotelBookingSystem;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelManager {
    // book room checkin
    // show empty rooms
    // show guest details
    // release room checkout
    private Hotel hotel;
    private BookingService bookingService;
    public HotelManager(Hotel hotel){
        this.hotel= hotel;
        this.bookingService = new BookingService(hotel);
    }

    public void bookRoom(Guest guest, RoomType roomType, LocalDate checkin, LocalDate checkout){

        Room availableRoom = hotel.rooms.stream()
                .filter(r-> (r.getRoomType() == roomType))
                .filter(r-> (bookingService.isRoomAvailable(r,checkin, checkout)))
                .findFirst().orElse(null);

        if(availableRoom != null){
            Booking booking = new Booking(availableRoom, guest, checkin, checkout);
            bookingService.bookRoom(booking);
            System.out.println("Booking done for room number" + booking.getRoom().getRoomNumber() + "for guest = "
                    + guest.getName() );
        }else {
            System.out.println("Room not available");
        }
    }





}
