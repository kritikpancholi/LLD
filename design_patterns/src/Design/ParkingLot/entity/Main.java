package Design.ParkingLot.entity;

import Design.TicTacToe.Game;

public class Main {
    public static void main(String[] args) {

        ParkingBuilding parkingBuilding = new ParkingBuilding();

        parkingBuilding.addFloor(5,1,0);
        parkingBuilding.addFloor(2,1,1);

        parkingBuilding.findParking(VehicleType.BIKE);
        parkingBuilding.parkVehicle(VehicleType.BIKE, "MH02", 0, 0);
        parkingBuilding.parkVehicle(VehicleType.BIKE,"MH03",1,0);

        parkingBuilding.printAllFreeSlots();

        parkingBuilding.findParking(VehicleType.BIKE);

        parkingBuilding.freeParking(VehicleType.BIKE,1,0);
    }
}

