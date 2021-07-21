package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild 
{
	public AddPlace addPlacePayLoad(String name,String language,String address)
	{
		AddPlace addplace = new AddPlace();
		addplace.setAccuracy(50);
		addplace.setAddress(address);
		addplace.setLanguage(language);
		addplace.setPhone_number("(+91) 983 893 3937");
		addplace.setWebsite("http://google.com");
		addplace.setName(name);
		
		List<String> listsetype = new ArrayList<String>();
		listsetype.add("shoe park");
		listsetype.add("shop");
		
		addplace.setTypes(listsetype);
		
		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		
		
		addplace.setLocation(location);
		return addplace;
	}
	
	public String  deletePlacePayload(String place_id)
	{
		return "{\r\n    \"place_id\":\""+place_id+"\"\r\n}";
	}
	

}
