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

import java.util.ResourceBundle;

import api.payload.*;
//UserEndpoints.java 
//Created to perform Create, Read, Update, Delete requests to the User services 

public class userendpoint2 {
	//code to load from properties file using resourcebundle class
	static ResourceBundle geturl()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response createUser(User payload) {
		
		String post_url=geturl().getString("post_url");
		
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(post_url);
		return response;
	}
	public static Response readUser(String username) {
		String get_url=geturl().getString("get_url");
		Response response=given()
	      .pathParam("username", username)
		.when()
		.get(get_url);
		return response;
	}
	public static Response updateUser(String username, User payload) {
		String update_url=geturl().getString("update_url");
		
		Response response=given()
		.contentType(ContentType.JSON)//from swagger will get
		.accept(ContentType.JSON)     //from swagger will get
		.pathParam("username",username)
		.body(payload)
		.when()
		.put(update_url);
		return response;
	}
	public static Response deleteUser(String username) {
		String delete_url=geturl().getString("delete_url");
		Response response=given()
	      .pathParam("username", username)
		.when()
		.delete(delete_url);
		return response;
	}
	
}
