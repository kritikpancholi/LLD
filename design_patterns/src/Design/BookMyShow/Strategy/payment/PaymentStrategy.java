package Design.BookMyShow.Strategy.payment;

import Design.BookMyShow.entities.Booking;

public interface PaymentStrategy {
    public void pay(Booking booking);
}
