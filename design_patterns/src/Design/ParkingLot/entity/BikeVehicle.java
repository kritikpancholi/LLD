package Design.ParkingLot.entity;

public class BikeVehicle extends Vehicle {

    String numberPlate;
    public BikeVehicle(String numberPlate){
        super(VehicleType.BIKE);
        this.numberPlate = numberPlate;
    }

    public String getNumberPlate() {
        return numberPlate;
    }
}
