package parkinglot;
import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.*;

public class Ticket {
	
	private int ticketNo;
	private Vehicle vehicle;
	private LocalDateTime entryTime;
	private ParkingSlot assignedNo;
	
	public Ticket(int ticketNo,Vehicle vehicle,LocalDateTime entryTime,ParkingSlot assignedNo)
	{
		this.ticketNo = ticketNo;
		this.vehicle = vehicle;
		this.entryTime = entryTime;
		this.assignedNo = assignedNo;
		
	}
	
	public int getTicketNo()
	{
		return ticketNo;
	}
	public Vehicle getVehicle()
	{
		return vehicle;
	}
	public LocalDateTime getEntryTime()
	{
		return entryTime;
	}
	public ParkingSlot getAssignedNo()
	{
		return assignedNo;
	}
	
	

}
