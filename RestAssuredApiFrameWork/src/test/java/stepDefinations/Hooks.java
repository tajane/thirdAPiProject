package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;



public class Hooks 
{
	// when we mention tag name into before-hook then system understand, before-hook method run
	//before the tag @deleteplace which is mention in feature file
	 
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
	// execute this code for get place id for delete place
		// we have to run this case only when place id is null
	
	// we are not calling to complete scenario we just calling to one method which is create place id
		
		StepDefination stepDefination = new StepDefination();
		
		if(StepDefination.place_id==null)
		{
			stepDefination.add_Place_Payload_with("nitin", "french", "pune");
			stepDefination.user_call_with_post_http_request("addPlaceAPI", "POST");
			stepDefination.verify_place_id_created_maps_to_using("nitin", "getPlaceAPI");
		}
		
		
	}

}
