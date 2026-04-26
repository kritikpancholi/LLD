package Design.HotelBookingSystem;

import java.time.temporal.ChronoUnit;

public class BillService {

    public int getBillAmount(Booking booking){
        long stayDays = ChronoUnit.DAYS.between(
                booking.getCheckin(),
                booking.getCheckout()
        );

        return (int) stayDays * booking.getRoom().getPrice();
    }

}
