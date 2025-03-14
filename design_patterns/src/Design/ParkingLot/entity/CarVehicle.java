package Design.ParkingLot.entity;

public class CarVehicle extends Vehicle {

    String numberPlat;
    public CarVehicle(String numberPlat){
        super(VehicleType.CAR);
        this.numberPlat = numberPlat;
    }

    public String getNumberPlat() {
        return numberPlat;
    }
}
