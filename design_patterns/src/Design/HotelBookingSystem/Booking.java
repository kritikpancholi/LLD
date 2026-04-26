package Design.HotelBookingSystem;

import java.time.LocalDate;

public class Booking {

    public Room room;
    public Guest guest;
    public LocalDate checkin;
    public LocalDate checkout;

    public Booking(Room room, Guest guest, LocalDate checkin, LocalDate checkout){
        this.checkin = checkin;
        this.checkout = checkout;
        this.room = room;
        this.guest = guest;
    }

    public Guest getGuest() {
        return guest;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public Room getRoom() {
        return room;
    }
}

