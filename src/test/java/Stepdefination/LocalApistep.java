package Stepdefination;

import java.util.HashMap;

//import org.junit.Assert;
import org.junit.runner.Request;
import org.testng.Assert;
import utils.UserId;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import requestmethod.ReqMethod;
import static io.restassured.RestAssured.*;
import utils.Hooks;

public class LocalApistep {
	public static String BaseUrl = "http://localhost:3000";

	public String endpoint;
	public Request request;
	public Response response;
	public String path;
	//public Hooks hooks=new Hooks();

	@Given("the API endpoint is {string}")
	public void the_api_endpoint_is(String string) {
		endpoint = string;
		System.out.println(string); 
		Hooks.extentTest.pass("API endpoint set to: " + string);
		
	}
	
	/*
	 * @When("I send a POST request") public void i_send_a_post_request() {
	 * //RestAssured.baseURI = BaseUrl; HashMap<String, Object> map = new
	 * HashMap<>(); map.put("id", "4"); map.put("name", "ss"); map.put("city",
	 * "shanthigodu"); response=ReqMethod.sendRequest();
	 * 
	 * 
	 * 
	 * response = given() .header("Content-Type", "application/json") .body(map)
	 * .when() .post(endpoint); System.out.println(response.body());
	 * //System.out.println(BaseUrl+endpoint); System.out.println(1); UserId.id="4";
	 * }
	 */
	
	@Given("I have valid user data from {string}")
	public void i_have_valid_user_data_from(String string) {
path=string;
Hooks.extentTest.pass("I have valid user data from "+string);
	}
	
	@When("I send a {string} request")
	public void i_send_a_request(String string) {
		/*
		 * //RestAssured.baseURI = BaseUrl; HashMap<String, Object> map = new
		 * HashMap<>(); map.put("id", "4"); map.put("name", "sss"); map.put("city",
		 * "shanthigodu");
		 */
		response=ReqMethod.sendRequest(string,endpoint,BaseUrl);
		
	
		/*
		 * response = given() .header("Content-Type", "application/json") .body(map)
		 * .when() .post(endpoint); System.out.println(response.body());
		 * //System.out.println(BaseUrl+endpoint);
		 */            System.out.println(1);
		 Hooks.extentTest.pass(String.format("I send a %s request",string));
		 
	            
	}

	@Then("the response status should be {int}")
	public void the_response_status_should_be(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
		// System.out.println("Response Body: " + response.asString());
		try{String number = response.jsonPath().getString("id");
		System.out.println("get"+number);UserId.id=number;
		 Hooks.extentTest.pass(String.format("the response status should be %s",int1));
	}
		catch (Exception e) {
            // Catching all exceptions (General error)
            System.out.println("An error occurred: " + e.getMessage());
            //e.printStackTrace();  // Prints the stack trace for debugging
        }
	}
	
	/*
	 * @When("I send a GET request") public void i_send_a_get_request() {
	 * System.out.println(endpoint + UserId.id); RestAssured.baseURI =
	 * "http://localhost:3000"; response = given().when().get(endpoint + UserId.id);
	 * }
	 */
	 
}
