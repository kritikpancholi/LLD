package Design.BookMyShow.entities;

import Design.BookMyShow.enums.SeatType;

public class NormalSeat extends Seat{

    public NormalSeat(int id, int price) {
        super(id,SeatType.NORMAL,price);
    }
}
