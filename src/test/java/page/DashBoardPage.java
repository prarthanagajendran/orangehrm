package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class DashBoardPage extends ProjectSpecificationMethod {

	@FindBy(xpath = "//h6[text()='Dashboard']")
	WebElement dashboard;
	
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	public DashBoardPage validateLogin(String type,String expText) {
		if(type.equalsIgnoreCase("ValidUNValidPass")) {
			String actualText=dashboard.getText();
			hardAssertCheck(actualText,expText);
			
		}
		return this;
		
	}
		
	}

