package Design.ParkingLot.entity;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    int floorId;
    public int carSize , bikeSize ;
    public List<ParkingSpot> car;
    public List<ParkingSpot> bike;

    Floor(int carSize, int bikeSize, int floorId){
        this.floorId = floorId;
        this.carSize = carSize;
        this.bikeSize = bikeSize;
        car = new ArrayList<>(carSize);
        bike = new ArrayList<>(bikeSize);
        for(int i = 0;i<carSize;i++){
            car.add(new ParkingSpot(i,VehicleType.CAR));
        }
        for(int i=0;i<bikeSize;i++){
            bike.add(new ParkingSpot(i, VehicleType.BIKE));
        }
//        bike = new ArrayList<>(bikeSize);
    }

    public boolean parkVehical(VehicleType vehicleType, String numbserPlate, int slotId){

        Vehicle vehicleToPark = null;
        if(vehicleType == VehicleType.BIKE){
                if(bike.get(slotId).isAvailable){
                    vehicleToPark = new BikeVehicle(numbserPlate);
                    bike.get(slotId).park(vehicleToPark);
                    System.out.println("bike parked at floor= "+ floorId + " at = "+ slotId);
                }
        } else if (vehicleType == VehicleType.CAR) {
                if(car.get(slotId).isAvailable){
                    vehicleToPark = new CarVehicle(numbserPlate);
                    car.get(slotId).park(vehicleToPark);
                    System.out.println("car parked at floor= "+ floorId + " at = "+ slotId);
                }
        }
        if(vehicleToPark == null){
            System.out.println("Parking spot not available");
            return false;
        }else return true;

    }
    public boolean freeParking(VehicleType vehicleType , int slotId){
        if(vehicleType.equals(VehicleType.BIKE)){
            bike.get(slotId).freeParking();
            System.out.println("Bike parking free for floor = "+floorId + " slot = "+ slotId);
            return true;
        }else if(vehicleType.equals(VehicleType.CAR)){
            car.get(slotId).freeParking();
            System.out.println(" Car parking free for floor = "+ floorId + " slot = "+ slotId);
            return true;
        }
        return false;
    }

    public boolean findParking(VehicleType vehicleType){
        if(vehicleType == VehicleType.CAR){
            for(int i = 0;i<carSize;i++){
                if(car.get(i).isAvailable){
                    System.out.println("Car parking available at Floor = "+floorId+" at slot id ="+i);
                    return true;
                }
            }
        }else if(vehicleType == VehicleType.BIKE){
            for(int i = 0;i<bikeSize;i++){
                if(bike.get(i).isAvailable){
                    System.out.println("Bike parking available at Floor = "+floorId+" at slot id ="+i);
                    return true;
                }
            }
        }
        return  false;
    }

    public void printAllFreeSlots(){
        System.out.println("Bike parking free slots for floor id = "+ floorId );

        for(int i = 0;i<bikeSize;i++){
            if(bike.get(i).isAvailable){
                System.out.print(i + " ");
            }
        }

        System.out.println("Car parking free slots for floor id = "+ floorId );
        for(int i = 0;i<carSize;i++){
            if(car.get(i).isAvailable){
                System.out.print(i + " ");
            }
        }
    }
}

