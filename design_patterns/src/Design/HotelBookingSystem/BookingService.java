package Design.HotelBookingSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingService {

    public Hotel hotel;

    public BookingService(Hotel hotel){
        this.hotel = hotel;
    }

    public Boolean isRoomAvailable(Room room , LocalDate checkin, LocalDate checkout){
        return hotel.getBooking().stream()
                .filter(r-> (r.getRoom().equals(room)))
                .noneMatch(b -> checkin.isBefore(b.getCheckout()) && checkout.isAfter(b.getCheckin()));
    }

    public void bookRoom(Booking booking){
        hotel.addBooking(booking);
    }

}
