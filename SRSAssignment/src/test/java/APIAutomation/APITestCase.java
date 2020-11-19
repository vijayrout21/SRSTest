package APIAutomation;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import utils.Utils;

public class APITestCase extends Utils{

	@Test
	public void createUser() throws IOException {
		String token="979e7bb0e536035a850a0120999eb59d334efe332f27f85e92f82b394570d93b";
		String baseURL=readProperties("APIUrl");
		System.out.println(baseURL);
		String payload="{\r\n" + 
				"	\"name\": \"Tenali Ramakrishna\",\r\n" + 
				"	\"gender\": \"Male\",\r\n" + 
				"	\"email\": \"tenali.rmcdwa@15ce.com\",\r\n" + 
				"	\"status\": \"Active\"\r\n" + 
				"}";
		
		RequestSpecification httpRequest = RestAssured.given().contentType(ContentType.JSON).header("authorization", "Bearer "+token).body(payload);
		
		
		Response response = httpRequest.post(baseURL);
		
		System.out.println(response.asString());
		
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		String code = jsonPathEvaluator.getString("code");
		
		System.out.println("Response code on creating user is:"+code);
		Assert.assertEquals(code, "201");
		
		//Get the users
		
		String userID=jsonPathEvaluator.getString("data.id");
		
		System.out.println(userID);
		
		RequestSpecification httpRequest1 = RestAssured.given().contentType(ContentType.JSON).header("authorization", "Bearer "+token);
		Response response1 = httpRequest1.get(baseURL+"/"+userID);
		 System.out.println(response1.asString());
		 
		 JsonPath jsonPathEvaluator1 = response1.jsonPath();
		 
		 String code1 = jsonPathEvaluator1.getString("code");
		
		 System.out.println("Response code on getting user is:"+code1);
			Assert.assertEquals(code1, "200");
	}
}
