package parkinglot;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;


public class ParkingService {
	
	private ParkingLot parkinglot;
	private int nextTicketId;
	
	public ParkingService(ParkingLot parkinglot)
	{
		this.parkinglot = parkinglot;
		this.nextTicketId = 1;
	}

	public Ticket parkVehicle(Vehicle vehicle)
	{
		List<ParkingFloor> floors = parkinglot.getFloors();
		for(ParkingFloor floor:floors)
		{
			for(ParkingSlot slot : floor.getSlots())
			{
				if(slot.getSpotType().canFit(vehicle.getVehicleType()) && slot.getIsAvailable())
				{
					slot.setIsAvailable(false);
					return new Ticket(nextTicketId++,vehicle,LocalDateTime.now(),slot);
				}
			}
		}
		return null;
		
	}
	public double unparkVehicle(Ticket ticket)
	{
		ParkingSlot slot = ticket.getAssignedNo();
		
		slot.setIsAvailable(true);
		
		long hours =Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours();
		double fare = hours*20;
		
		return fare;
	}
	
	

}
