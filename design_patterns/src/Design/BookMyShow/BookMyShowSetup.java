package Design.BookMyShow;

import Design.BookMyShow.Services.BookingService;
import Design.BookMyShow.Services.CinemaService;
import Design.BookMyShow.Services.ShowService;
import Design.BookMyShow.entities.*;
import Design.BookMyShow.enums.PaymentType;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.List;

public class BookMyShowSetup {

    public BookMyShow bookMyShow = BookMyShow.getBookMyShowInstance();
    public void run(){
        CinemaService cinemaService = bookMyShow.getCinemaService();
        ShowService showService = bookMyShow.getShowService();
        BookingService bookingService = bookMyShow.getBookingService();

        cinemaService.createCinema(1,"Tower_1");
        Screen screen1 = cinemaService.addScreen(1,1,10,20);

        Screen screen2 = cinemaService.addScreen(1,2,20,30);

        City puneCity = new City(1,"pune");
        // create movie
        Movie rockstarMovie = new Movie("rockstar",1);
        Movie tree = new Movie("Tree", 2);

        showService.addShow(1,cinemaService.getCinema(1),rockstarMovie,
                LocalDateTime.of(2026, 5, 10, 18, 30), puneCity, screen1);

        showService.addShow(
                2,
                cinemaService.getCinema(1),
                tree,
                LocalDateTime.of(2026, 5, 10, 21, 0),
                puneCity,
                screen2
        );

        Show treeShow =showService.getShowByCityAndMovie(puneCity, tree);
        System.out.println("Show movie name = "+ treeShow.getMovie().getName() + " Show id = " + treeShow.getId());

        Booking userOneBooking = bookingService.CreateBooking(treeShow, 1, 1, List.of(1, 31)); // 1 premium seat 1 normal seat
        Booking user2Booking;
        try {
            user2Booking = bookingService.CreateBooking(treeShow, 1, 2, List.of(1, 2)); // another try to book
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            Thread.sleep(5000L);
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            bookingService.confirmBooking(PaymentType.UPI, userOneBooking);
        }catch (Exception e){
            System.out.println(e);
        }
        user2Booking = bookingService.CreateBooking(treeShow, 2, 2, List.of(1, 2));

        try{
            bookingService.confirmBooking(PaymentType.UPI,user2Booking);
        }catch (Exception e ){
            System.out.println(e);
        }



    }

}
