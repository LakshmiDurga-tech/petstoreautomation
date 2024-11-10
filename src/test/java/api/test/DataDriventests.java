package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import api.utilities.*;
import io.restassured.response.Response;
import api.endpoints.userendpoint;
import api.payload.*;

public class DataDriventests {
    


	@Test(priority=1,dataProvider="data",dataProviderClass=dataproviders.class)
     void testpostuser(String id, String username, String firstname,String lastname, String email,String pass,String ph)
     {
    	 User userpayload=new User();
    	 userpayload.setId(Integer.parseInt(id));
    	 userpayload.setUsername(username);
    	 userpayload.setFirstname(firstname);
    	 userpayload.setLastname(lastname);
    	 userpayload.setEmail(email);
    	 userpayload.setPassword(pass);
    	 userpayload.setPhone(ph);
    	 
    	 Response response=userendpoint.createUser(userpayload);
    	 Assert.assertEquals(response.getStatusCode(), 200);
     }
	@Test(priority=2,dataProvider="username",dataProviderClass=dataproviders.class)
	void testdeleteuser(String username)
	{
		Response response=userendpoint.deleteUser(username);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
