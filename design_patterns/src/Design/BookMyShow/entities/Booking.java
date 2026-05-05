package Design.BookMyShow.entities;

import Design.BookMyShow.enums.BookingStatus;
import Design.BookMyShow.enums.PaymentStatus;
import Design.BookMyShow.enums.PaymentType;

import java.util.List;

public class Booking {

    private int bookingId;
    private int showId;
    private int userId;
    private BookingStatus bookingStatus;
    private List<Seat> bookingSeats;
    private double amount;
    private PaymentType paymentType;

    public Booking(int showId, int bookingId, int userId, List<Seat> seatList, double amount, BookingStatus bookingStatus){
        this.showId = showId;
        this.bookingId = bookingId;
        this.userId = userId;
        this.bookingSeats = seatList;
        this.bookingStatus = bookingStatus;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public List<Seat> getBookingSeats() {
        return bookingSeats;
    }

    public int getUserId() {
        return userId;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getShowId() {
        return showId;
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }
}
