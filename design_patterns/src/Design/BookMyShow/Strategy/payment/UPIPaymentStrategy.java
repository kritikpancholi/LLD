package Design.BookMyShow.Strategy.payment;

import Design.BookMyShow.entities.Booking;

public class UPIPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(Booking booking) {
        System.out.println("Payment using UPI of amount "+ booking.getAmount() + " for show id= "+booking.getShowId());
    }
}
