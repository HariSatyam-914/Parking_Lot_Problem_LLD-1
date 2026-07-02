package parkinglot;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		
		// Build a floor with one BIKE slot and one CAR slot
        List<ParkingSlot> slots = new ArrayList<>();
        slots.add(new ParkingSlot("S1", SpotType.BIKE));
        slots.add(new ParkingSlot("S2", SpotType.CAR));
        
        ParkingFloor floor1 = new ParkingFloor(slots, 1);
        
        List<ParkingFloor> floors = new ArrayList<>();
        floors.add(floor1);
        
        ParkingLot lot = new ParkingLot("Test Lot", "123 Main St", floors);
        ParkingService service = new ParkingService(lot);
        
        // Park a car
        Vehicle car = new Vehicle("AP01AB1234", VehicleType.CAR);
        Ticket ticket = service.parkVehicle(car);
        
        if (ticket == null) {
            System.out.println("No slot available for car.");
        } else {
            System.out.println("Parked. Ticket No: " + ticket.getTicketNo());
            System.out.println("Assigned slot: " + ticket.getAssignedNo().getSpotId());
            
            // Unpark it and check fare
            double fare = service.unparkVehicle(ticket);
            System.out.println("Fare: " + fare);
        }
        
        // Try parking a second car — should fail, no CAR slot left (unless canFit lets it use TRUCK)
        Vehicle car2 = new Vehicle("AP02CD5678", VehicleType.CAR);
        Ticket ticket2 = service.parkVehicle(car2);
        System.out.println(ticket2 == null ? "Correctly rejected: no slot for car2." 
                                            : "Ticket issued: " + ticket2.getTicketNo());

	}

}

