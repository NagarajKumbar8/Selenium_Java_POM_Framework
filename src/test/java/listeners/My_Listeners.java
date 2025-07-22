package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import base_test.base_test;
import utilities.ExtentReporter;
import utilities.Utils;

public class My_Listeners extends base_test implements ITestListener {

	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	
	ThreadLocal<ExtentTest> extentT=new ThreadLocal<ExtentTest>(); // thread safe 

	@Override
	public void onTestStart(ITestResult result) {
		
		extentTest = extentReport.createTest(result.getMethod().getMethodName());
		extentT.set(extentTest);  //unique thread ID
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentT.get().log(Status.PASS,"Test Passed");
		//extentTest.log(Status.PASS,"Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		extentT.get().fail(result.getThrowable());
		
		 WebDriver driver = null;
		 
		 String testName = result.getName();
		 
		 
		 try {
			 
			 driver =(WebDriver) result.getTestClass().getRealClass().getField("driver")
					 .get(result.getInstance());
			 		 
				/*
				 * Field field =
				 * result.getTestClass().getRealClass().getDeclaredField("driver");
				 * field.setAccessible(true); // Allow access to private field driver =
				 * (WebDriver) field.get(result.getInstance());
				 */
			} catch (Exception e1) {
			    e1.printStackTrace();
			}
		 
		 
		 try {
			 
			String screenshotPath = Utils.takeScreenshot(testName,driver);
			extentT.get().addScreenCaptureFromPath(screenshotPath, testName); 
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
		
	}

	
}
