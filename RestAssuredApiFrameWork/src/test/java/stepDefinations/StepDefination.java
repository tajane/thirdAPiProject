package stepDefinations;

import static org.junit.Assert.assertEquals;
import static io.restassured.RestAssured.given;
import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils
{
	RequestSpecification res;
	Response response;
	TestDataBuild data = new TestDataBuild();
	public static String place_id;
	// value should be fix nothing will be change for next scenario that's why we make it static
	
	// once first scenario execute then all above variable set to null 
	// if we  make it static then it hold previous value (its not treated as null)

	@Given("Add Place Payload with {string} {string} {string}")
	public void add_Place_Payload_with(String name,String language,String address) throws IOException 
	{		
		res = given().spec(requestSpecification()).body(data.addPlacePayLoad(name,language,address));
	}

	@When("User call {string} with {string} http request")
	public void user_call_with_post_http_request(String resource,String httpmethod) 
	{
		// constructor will be call with value of resources 
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResources());
		
		if (httpmethod.equalsIgnoreCase("POST")) 
		{
			System.out.println("print resources " + resourceAPI.getResources());
			response = res.when().post(resourceAPI.getResources());
			/*then().spec(responseSpecification()).extract().response();
			System.out.println("print the repsonse"+ response.asString());*/
		
		}else if (httpmethod.equalsIgnoreCase("GET")) 
		{
			System.out.println("print resources " + resourceAPI.getResources());
			response = res.when().get(resourceAPI.getResources());
			
			/*then().spec(responseSpecification()).extract().response();
			System.out.println("print the repsonse"+ response.asString());*/
		}	
	}

	@Then("The api call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) 
	{	    
	   assertEquals(response.statusCode(),200);
	}

	@And("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) 
	{
	   assertEquals(getJsonPath(response,key),value);
	}
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedname , String resource) throws IOException 
	{
		place_id = getJsonPath(response,"place_id");
		res = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_call_with_post_http_request(resource, "GET");
		String actualname = getJsonPath(response,"name");
		assertEquals(actualname,expectedname);
	}
	
	@Given("delete Place payload")
	public void delete_Place_payload() throws IOException 
	{
		res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}
}
