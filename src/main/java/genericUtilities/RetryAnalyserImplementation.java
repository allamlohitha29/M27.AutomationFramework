package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation of IRetryAnalayser interface of TestNG 
 * @author Lohitha
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer  {
	
	int count = 0;
	int retrycount = 3; //Manual analysis
	
	public boolean retry(ITestResult result)
	{
		
		//0<3  1<3  2<3  3<3 -No
		while(count<retrycount)
		{
			count++;
			return true; //retry
		}
		
		return false; //stop retry
	}
	

}
