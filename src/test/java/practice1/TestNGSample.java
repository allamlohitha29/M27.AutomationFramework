package practice1;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGSample {
	
//	
//	@Test(invocationCount = 3,priority = 2)
//	public void createSample()
//	{
//		System.out.println("Create");
//	}
//	
//	@Test(priority = 1)
//	public void modifySample()
//	{
//		System.out.println("Modify");
//	}
//	
//	@Test
//	public void deleteSample()
//	{
//		System.out.println("Delete");
//	}
	
	
	
	
	

//	@Test
//	public void createSample()
//	{
//		//Assert.fail(); //forcefully fail
//		System.out.println("Create");
//	}
//	
//	@Test(dependsOnMethods = "createSample")
//	public void modifySample()
//	{
//		System.out.println("Modify");
//	}
//	
//	@Test(enabled = false)
//	public void deleteSample()
//	{
//		System.out.println("Delete");
//	}
	
	
	@Test(dataProvider = "getData")
	public void createEmpData(String name,int id)
	{
		
		System.out.println("Name is - "+name);
		System.out.println("ID is - "+id);
	}
	
	@DataProvider
	public Object[][] getData()
	{
	  Object[][] data=new Object[3][2];//3*2 - three datsasets and each consists  of 2 info
	  
	  
	 //1st data set
	  data[0][0] = "Chaitra";
	  data[0][1] = 12;
	  
			//2nd data set
			  data[1][0] = "Duvith";
			  data[1][1] =  8;
			  
					//3rd data set
					  data[2][0] = "Sree" ;
					  data[2][1] =  14;
					  
					  return data;
			  
	}
	

}
