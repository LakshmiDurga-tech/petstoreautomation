package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.github.javafaker.Faker;

import api.endpoints.userendpoint;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {
    Faker faker;
    User payload;
    public Logger logger;
    @BeforeClass
  public void setupdata()
  {
	  faker=new Faker();
	  payload=new User();
	  payload.setId(faker.idNumber().hashCode());
	  payload.setUsername(faker.name().username());
	  payload.setFirstname(faker.name().firstName());
	  payload.setLastname(faker.name().lastName());
	  payload.setEmail(faker.internet().safeEmailAddress());
	  payload.setPassword(faker.internet().password(5, 10));
	  payload.setPhone(faker.phoneNumber().cellPhone());
	  logger=LogManager.getLogger(this.getClass());
  }
 @Test(priority=1)
 public void testpostuser()
 {
	 Response response=userendpoint.createUser(payload);
	 response.then().log().all();
	 Assert.assertEquals(response.getStatusCode(), 200);
 }
 @Test(priority=2)
 public void testgetuser()
 {
	 Response response=userendpoint.readUser(this.payload.getUsername());
	 response.then().log().all();
	 response.statusCode();//normal we use statuscode
	 Assert.assertEquals(response.getStatusCode(), 200);//if aasertion we need to use getStatuscode
 }
 @Test(priority=3)
 public void testupdateuser()
 {
	 logger.info("update");
	 payload.setFirstname(faker.name().firstName());
	  payload.setLastname(faker.name().lastName());
	  payload.setEmail(faker.internet().safeEmailAddress());
	  
	  Response response=userendpoint.updateUser(this.payload.getUsername(), payload);
			  response.then().log().body();
			  Assert.assertEquals(response.getStatusCode(), 200);
			  //username check after update
			  
			  
 }
 @Test(priority=4)
 public void testdeleteuser()
 {
	 logger.info("deleted");
	 Response response=userendpoint.deleteUser(this.payload.getUsername());
	 response.then().log().all();
	 Assert.assertEquals(response.getStatusCode(), 200);
			 
 }


}
