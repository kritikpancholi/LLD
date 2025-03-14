package Design.ParkingLot.entity;

import java.util.ArrayList;
import java.util.List;

public class ParkingBuilding {

    int id =0;
    List<Floor> floor = new ArrayList<Floor>();



    public void addFloor(int carSize, int bikeSize, int floorId){
        floor.add(new Floor(carSize, bikeSize, floorId));
        System.out.println("Floor with id = "+ floorId + "added to building id = "+ id);

    }
    public void findParking(VehicleType vehicleType){
        boolean key= false;
        for(int i =0;i<floor.size();i++){
            if(floor.get(i).findParking(vehicleType)){
                key = true;
                break;
            }
        }
        if(key == false){
            System.out.println("No parking available");
        }
    }
    public void parkVehicle(VehicleType  vehicleType, String numberPlate, int floorId, int slotId){
        floor.get(floorId).parkVehical(vehicleType, numberPlate, slotId);
    }

    public void freeParking(VehicleType vehicleType, int floorId, int slotId){
        floor.get(floorId).freeParking(vehicleType, slotId);
    }

    public void printAllFreeSlots(){
        for(int i =0 ;i<floor.size();i++){
            floor.get(i).printAllFreeSlots();
        }
    }

}
