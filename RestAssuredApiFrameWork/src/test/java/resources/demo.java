package resources;

public class demo 
{

	// this is constant we declare here and we use that variable in main class 
	// so to declare variable we need to create method for each every constant 
	// so it take more time  and it having more maintains 
	
	
	
	String addPlaceAPI = "maps/api/place/add/json";
	String getPlaceAPI = "maps/api/place/get/json";
	String deletePlaceAPI = "maps/api/place/delete/json";
	
	public String getAddPlaceAPI()
	{
		return addPlaceAPI;
	}
	
	public String getPlaceAPI()
	{
		return getPlaceAPI;
	}
	
	public String getDeletePlaceAPI()
	{
		return deletePlaceAPI;
	}
	
	
}
