package parkinglot;

public enum SpotType {
    BIKE, CAR, TRUCK;

    public boolean canFit(VehicleType vehicleType) {
        switch (this) {
            case TRUCK: return true;
            case CAR: return vehicleType == VehicleType.CAR || vehicleType == VehicleType.BIKE;
            case BIKE: return vehicleType == VehicleType.BIKE;
            default: return false;
        }
    }
}