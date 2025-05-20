package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides  implementation to ITestlistener interface of TestNG
 * @author Lohitha
 */
public class ListenersImplementation implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		
		// capture Method name
		String methodName = result.getMethod().getMethodName();
		System.out.println("#"+methodName+" Test Script execution Started#");
		
		//Intimate the Extent Report for Test Execution
		 test =report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		// capture Method name
		String methodName = result.getMethod().getMethodName();
		System.out.println("#"+methodName+" Test Script execution PASS #");
		
		//Log The Status as PASS in Extent Report
		test.log(Status.PASS, methodName+" Test Script execution PASS #");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		// capture Method name
		String methodName = result.getMethod().getMethodName();
		System.out.println("#"+methodName+" Test Script execution FAIL #");
		
		//capture Exception
		System.out.println(result.getThrowable());
		
		//Log The Status as FAIL in Extent Report
		test.log(Status.FAIL, methodName+" Test Script execution PASS #");
		
		//Log The Exception Captured To Extent Report
		test.log(Status.WARNING, result.getThrowable());
		
		
		//capture screenshot
		JavaUtility j=new JavaUtility();
		SeleniumUtility s=new SeleniumUtility();
		String screenshotName= methodName+"-"+j.getSystemDate();
		
		try {
			String path = s.captureScreenshot(BaseClass.sdriver, screenshotName);
			
			//attach Screenshot To Report
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		// capture Method name
		String methodName = result.getMethod().getMethodName();
		System.out.println("#"+methodName+"Test Script execution SKIP #");
		
		//capture Exception
		System.out.println(result.getThrowable());
		
		//Log The Status as SKIP in Extent Report
		test.log(Status.SKIP, methodName+" Test Script execution SKIP #");
				
		//Log The Exception Captured To Extent Report
		test.log(Status.WARNING, result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("# Suite execution Started #");
		
		//basic configuration of extent reports
		ExtentSparkReporter esr=new ExtentSparkReporter(".\\ExtentReports\\Report- "+new JavaUtility().getSystemDate()+".html");
		esr.config().setDocumentTitle("Swags Lab Execution Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Automation Execution Report");
		
		//Report Generation
		report=new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Env", "Testing");
		report.setSystemInfo("Reporter name", "Lohitha");
		

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("# Suite execution Finished #");
		
		//Generate Extent Report
		report.flush();
	}
	
	
	

}
