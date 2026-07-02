package parkinglot;

//public enum SpotType{TWO_WHEELER,FOUR_WHEELER} 
public class ParkingSlot {
	
	private String spotId;
	private SpotType spotType;
	private boolean isAvailable;
	
	public ParkingSlot(String spotId,SpotType spotType)
	{
		this.spotId = spotId;
		this.spotType = spotType;
		isAvailable = true;
	}

	public String getSpotId()
	{
		return spotId;
	}
	public SpotType getSpotType()
	{
		return spotType;
	}
	
	public boolean getIsAvailable()
	{
		return isAvailable;
	}
	public void setIsAvailable(boolean isAvailable)
	{
		this.isAvailable = isAvailable;
	}
}
