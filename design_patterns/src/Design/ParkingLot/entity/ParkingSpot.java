package Design.ParkingLot.entity;

public class ParkingSpot {

    int spotId;
    public boolean isAvailable;
//    public String numberPlate;

    VehicleType parkingType ;
    Vehicle parkedVehicle;
//
    public ParkingSpot(int spotId, VehicleType parkingType){
        this.parkingType = parkingType;
        this.spotId = spotId;
        this.isAvailable = true;
    }

    public boolean CheckIsAvailable(){
        return isAvailable;
    }

    public void park(Vehicle vehicle){
        isAvailable = false;
        parkedVehicle = vehicle;
//        return true;
    }

    public void freeParking(){
        isAvailable = true;
    }

}
