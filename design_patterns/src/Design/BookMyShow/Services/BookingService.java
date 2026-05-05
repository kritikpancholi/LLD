package Design.BookMyShow.Services;

import Design.BookMyShow.Strategy.locking.LockProvider;
import Design.BookMyShow.Strategy.payment.PaymentStrategy;
import Design.BookMyShow.entities.Booking;
import Design.BookMyShow.entities.Show;

import Design.BookMyShow.entities.Seat;
import Design.BookMyShow.enums.BookingStatus;
import Design.BookMyShow.enums.PaymentType;
import Design.BookMyShow.enums.SeatStatus;
import Design.BookMyShow.excpetions.SeatNotAvailableException;
import Design.BookMyShow.factory.PaymentStrategyFactory;

import java.util.ArrayList;
import java.util.List;

public class BookingService {

    private List<Booking> booking;
    private final long TTL = 5000L;
    private final LockProvider lockProvider;

    public BookingService(LockProvider  lockProvider){
        this.booking = new ArrayList<>();
        this.lockProvider = lockProvider;
    }


    public Booking CreateBooking(Show show, int bookingId, int userId, List<Integer> seatList){

        // check seats are not booked already
        if(checkSeatAvailability(seatList, show)) {

            for(Integer seat : seatList){
                String key = show.getId() + ":" + seat;
                if(!lockProvider.tryLock(key, userId, TTL)){
                    throw new SeatNotAvailableException("Seat "+ seat + "is temporarily not available");
                }
            }
            double totalPrice = 0;

            List<Seat> bookingSeats = getBookingSeats(seatList, show);
            for(Seat s: bookingSeats){
                totalPrice += s.getPrice();
            }


            Booking newBooking = new Booking(
                    show.getId(),
                    bookingId,
                    userId,
                    bookingSeats,
                    totalPrice,
                    BookingStatus.CREATED);

            booking.add(newBooking);

            System.out.println("Booking created by userid " + userId + " BookingId " + bookingId);
            return newBooking;
        }
        else {
            System.out.println("Booking fail seat not available");
            return null;
        }
    }

    private Boolean checkSeatAvailability(List<Integer>seatList, Show show){
        return seatList.stream().allMatch(sId ->
                            { Seat seat = show.getScreen().getSeat(sId);
        return seat != null && seat.getSeatStatus() == SeatStatus.AVAILABLE;
                            });

    }

    private List<Seat> getBookingSeats(List<Integer> seatList, Show show){
        return new ArrayList<>( seatList.stream().map(s-> show.getScreen().getSeat(s)).toList());
    }

    public void confirmBooking(PaymentType paymentType, Booking booking){
        if(booking.getBookingStatus() != BookingStatus.CREATED) {
            throw new IllegalStateException("Booking is not created");
        }

        for(Seat seat : booking.getBookingSeats()){
            String key = booking.getShowId() + ":" + seat.getId();
            if( lockProvider.isLockExpired(key) || !lockProvider.isLockBy(key, booking.getUserId())){
                throw  new SeatNotAvailableException("Seat is not locked "+ seat.getId()+" is temporary not available");
            }
        }


        booking.setPaymentType(paymentType);
        PaymentStrategy paymentStrategy = PaymentStrategyFactory.getStretagy(paymentType);

        paymentStrategy.pay(booking);

        for(Seat seat: booking.getBookingSeats()){
            seat.setSeatStatus(SeatStatus.CONFIRMED);
        }



    }


}
