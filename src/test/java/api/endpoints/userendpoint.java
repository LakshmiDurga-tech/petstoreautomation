package api.endpoints;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import com.github.javafaker.Faker;

import org.json.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import api.payload.*;
//UserEndpoints.java 
//Created to perform Create, Read, Update, Delete requests to the User services 

public class userendpoint {
	public static Response createUser(User payload) {
		
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_url);
		return response;
	}
	public static Response readUser(String username) {
		Response response=given()
	      .pathParam("username", username)
		.when()
		.get(Routes.get_url);
		return response;
	}
	public static Response updateUser(String username, User payload) {
		
		Response response=given()
		.contentType(ContentType.JSON)//from swagger will get
		.accept(ContentType.JSON)     //from swagger will get
		.pathParam("username",username)
		.body(payload)
		.when()
		.put(Routes.update_url);
		return response;
	}
	public static Response deleteUser(String username) {
		Response response=given()
	      .pathParam("username", username)
		.when()
		.delete(Routes.delete_url);
		return response;
	}
	
}
