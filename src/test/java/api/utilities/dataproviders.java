package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataproviders {
	@DataProvider(name="data")
   public String[][] getalldata() throws IOException
   {
	String path=System.getProperty("user.dir")+"//testdata//Userdata.xlsx";//we can use .// aswell
	XLUtility xl=new XLUtility(path);//sending path as part of constructor
	
	int rowcount=xl.getRowCount("Sheet1");
	int colcount=xl.getCellCount("sheet1", 1);
	
	String apidata[][]=new String[rowcount][colcount];
	for(int i=1;i<=rowcount;i++)
	{
		for (int j=0;j<colcount;j++)
		{
			apidata[i-1][j]=xl.getCellData("Sheet1", i, j);
		}
	}
	return apidata;
	}
	@DataProvider(name="username")
	public String[] getusername() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testdata//Userdata.xlsx";
		XLUtility xl=new XLUtility(path);//sending path as part of constructor
		
		int rowcount=xl.getRowCount("Sheet1");
		
		String apidata[]=new String[rowcount];
		for(int i=1;i<=rowcount;i++)
		{
			
				apidata[i-1]=xl.getCellData("Sheet1", i, 1);
			
		}
		return apidata;
	}
}
