package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils
{
	public static RequestSpecification res;
	// here we make static because we don't want to create new every time when we call to this method
	// so to avoid of creating new object we use static 
	//so every time request specification log added into file overriding previous report 
	// when you declare static that variable share across all over test cases 
	// when you declare static next time this variable not make null contain added into that variable
	ResponseSpecification responsespec;
	
	
	public RequestSpecification requestSpecification() throws IOException
	{
		if(res==null) 
		{
		PrintStream printstream = new PrintStream(new FileOutputStream("logging.txt"));
		res = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
		.addFilter(RequestLoggingFilter.logRequestTo(printstream)) // this logging request details
		.addFilter(ResponseLoggingFilter.logResponseTo(printstream)) //  this logging response details
		.setContentType(ContentType.JSON).build();
		return res;
		}
		return res;
		
		// here we use if else because we want to log every report because we this above method
		// call second time then previous report override and showing only last report 
	}
	
	public ResponseSpecification responseSpecification()
	{
		return responsespec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	}

	public String getGlobalValue(String key) throws IOException
	{
		Properties prob = new Properties();
		FileInputStream fiInputStream = new FileInputStream("C:\\Users\\Admin\\RestAssuredAPITest\\RestAssuredApiFrameWork\\src\\test\\java\\resources\\global.properties");
		prob.load(fiInputStream);
		return prob.getProperty(key);	
	}
	
	public String getJsonPath(Response response,String key)
	{
		 String res = response.asString();
		JsonPath jsonpath = new JsonPath(res);
		return jsonpath.get(key);
	}
	

	
}
