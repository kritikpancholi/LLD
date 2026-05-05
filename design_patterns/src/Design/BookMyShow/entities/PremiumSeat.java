package Design.BookMyShow.entities;

import Design.BookMyShow.enums.SeatType;

public class PremiumSeat extends Seat{
    public PremiumSeat(int id, int price){
        super(id, SeatType.PREMIUM, price);
    }
}
