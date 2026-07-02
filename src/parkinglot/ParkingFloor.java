package parkinglot;
import java.util.*;

public class ParkingFloor {
	
	private List<ParkingSlot> slots;
	private int floorNo;
	
	public ParkingFloor(List<ParkingSlot> slots,int floorNo)
	{
		this.slots=slots;
		this.floorNo =floorNo;
	}
	
	public List<ParkingSlot> getSlots()
	{
		return slots;
	}
	public int getFloorNo()
	{
		return floorNo;
	}
	
}
