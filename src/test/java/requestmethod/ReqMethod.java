package requestmethod;

import static io.restassured.RestAssured.given;

import java.io.*;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.UserId;
import Stepdefination.LocalApistep;

public class ReqMethod {
	
public static Response sendRequest(String request,String endpoint,String BaseUrl) {
	 RestAssured.baseURI = BaseUrl;
	 Response response = null;
	 String create_data;
	 String update_data;
	switch (request.toUpperCase()) {
    case "POST":
    	//HashMap<String, Object> data = new HashMap<>(); 
    	 /*HashMap<String, Object> map = new HashMap<>();
    		map.put("id", "4");
    		map.put("name", "Lekha");
    		map.put("city", "shanthigodu");
    		*/
    	ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> data;

        /*try {
            // Read JSON file into a Map
        	data = objectMapper.readValue(new File("C:\\Users\\sakum\\eclipse-workspace\\BDD_Restassured\\src\\test\\java\\userdata\\data.json"), Map.class); 
        	} 
        catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file", e);
        }	*/
        try {
             create_data= new String(Files.readAllBytes(Paths.get("C:\\Users\\sakum\\eclipse-workspace\\BDD_Restassured\\src\\test\\java\\userdata\\inputdata.json" )));
        } catch (IOException e) {
        	 throw new RuntimeException("Failed to read JSON file", e);
        }
    		response =given()
    	            .header("Content-Type", "application/json")
    	            .body(create_data)
    	            .when()
    	            .post(endpoint);
    	            //System.out.println(response.body());
    		 //System.out.println(BaseUrl+endpoint);
    		break;
    case "GET":
    	//System.out.println(endpoint + UserId.id); 
    	response = given().when().get(endpoint + UserId.id);
        break;
    case "PUT":
		/*
		 * HashMap<String, Object> map1 = new HashMap<>(); map1.put("id", "4");
		 * map1.put("name", "santh"); map1.put("city", "kakve");
		 */
    	try {
            update_data= new String(Files.readAllBytes(Paths.get(
               "C:\\Users\\sakum\\eclipse-workspace\\BDD_Restassured\\src\\test\\java\\userdata\\updatedata.json" )));
       } catch (IOException e) {
       	 throw new RuntimeException("Failed to read JSON file", e);
       }
 		response =given()
 	            .header("Content-Type", "application/json")
 	            .body(update_data)
 	            .when()
 	            .patch(endpoint+UserId.id);
 		break;
    case "DELETE":
    	response=given()
    	.when()
    	.delete(endpoint+UserId.id);
    	break;
    default:
        throw new IllegalArgumentException("Invalid HTTP method: " );


}
	return response;
	
	
}}