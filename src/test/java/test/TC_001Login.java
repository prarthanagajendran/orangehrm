package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.LoginPage;

public class TC_001Login extends ProjectSpecificationMethod {
      @BeforeTest	
       public void setup(){
    	 sheetname="loginData";
    	 testName="Login Test";
    	 testDescription="Testing login functionality";
    	 testAuthor="Prarthana";
    	 testCategory="smoke Testing";
      }
      
      @Test(dataProvider = "readData")
  	public void loginTest(String name,String pass, String testType,String expectedText) {
  		
  		LoginPage obj = new LoginPage(driver);
  		obj.enterUsername(name)
  		.enterPassword(pass)
  		.clicklogin()
  		.validateLogin(testType, expectedText);
    	  
    	  
    	 }
     
}

