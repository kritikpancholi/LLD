package Design.HotelBookingSystem;

public class Guest {

    public String id;
    public String name;
    public String mobileNumber;


    public Guest(String id, String name, String mobileNumber){
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
