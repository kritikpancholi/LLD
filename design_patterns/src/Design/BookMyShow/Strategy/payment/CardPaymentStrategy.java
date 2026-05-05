package Design.BookMyShow.Strategy.payment;

import Design.BookMyShow.entities.Booking;

public class CardPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(Booking booking) {
        System.out.println("Payment using Card of amount "+ booking.getAmount() + " for show id= "+booking.getShowId());
    }

}
