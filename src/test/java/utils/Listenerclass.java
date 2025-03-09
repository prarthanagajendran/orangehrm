package utils;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.ProjectSpecificationMethod;

public class Listenerclass extends ProjectSpecificationMethod implements ITestListener{
    @Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Test passed");
		String screenShotPath=null;
		try
		{
			screenShotPath=screenshot(result.getMethod().getMethodName()+"pass");
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(screenShotPath,"passed");
		
	}
	
	
    @Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		String screenShotPath=null;
		try
		{
			screenShotPath=screenshot(result.getMethod().getMethodName()+"fail");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenShotPath,"failed");

		
	}
	
	
	
}
