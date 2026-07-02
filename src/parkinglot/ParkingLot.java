package parkinglot;
import java.util.*;


public class ParkingLot {
	
	private String name;
	private String address;
	private List<ParkingFloor> floors;
	
	public ParkingLot(String name,String address,List<ParkingFloor> floors)
	{
		this.name = name;
		this.address = address;
		this.floors = floors;
	}
	
	public String getName()
	{
		return name;
	}
	public String getAddress()
	{
		return address;
	}
	public List<ParkingFloor> getFloors()
	{
		return floors;
	}
}
