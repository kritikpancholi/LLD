package Design.BookMyShow;

import Design.BookMyShow.Services.BookingService;
import Design.BookMyShow.Services.CinemaService;
import Design.BookMyShow.Services.ShowService;
import Design.BookMyShow.Strategy.locking.InMemoryLockProvider;


public class BookMyShow {

    private static BookMyShow bookMyShow;
    public CinemaService cinemaService;
    public ShowService showService;
    public BookingService bookingService;


    private BookMyShow(){
        this.cinemaService = new CinemaService();
        this.showService = new ShowService();
        this.bookingService = new BookingService(new InMemoryLockProvider());
    }

    public static BookMyShow getBookMyShowInstance(){
        if(bookMyShow != null) return bookMyShow;

        synchronized (BookMyShow.class){
        if(bookMyShow == null){
            bookMyShow = new BookMyShow();
            }
        return bookMyShow;
        }
    }

    public BookingService getBookingService() {
        return bookingService;
    }

    public CinemaService getCinemaService(){
        return this.cinemaService;
    }
    public ShowService getShowService(){
        return this.showService;
    }
}
