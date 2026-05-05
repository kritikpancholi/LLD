package Design.BookMyShow.entities;

import Design.BookMyShow.enums.SeatStatus;
import Design.BookMyShow.enums.SeatType;

public abstract class Seat {

    public int id;
    public SeatType seatType;
    public int price;
    public SeatStatus seatStatus;

    public Seat(int id, SeatType seatType, int price){
        this.id = id;
        this.seatType = seatType;
        this.price = price;
        this.seatStatus = SeatStatus.AVAILABLE;
    }

    public SeatType getSeatType(){
        return this.seatType;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }
}
