package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Utility;

public class ProjectSpecificationMethod extends Utility{

	@BeforeSuite
	public void reportIniatialization() {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter("C:\\Users\\Pradeep\\eclipse-workspace\\OrangeHRM\\reports\\OrangeHRMReporter.html");
		reporter.config().setReportName("OrangeHRM report");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	}
	
	@BeforeClass
	public void testDetails() {
		
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);

	}
	
	
	@Parameters({"url","browser"})
	@BeforeMethod
	public void launchBrowser(String url, String browser) {
		
		launchAndLoadUrl(url, browser);
		
	}
	
	@AfterMethod
	public void browserClose() {
		
		closingBrowser();
	}
	
	@DataProvider
	public String[][] readData() throws Exception {
		
		String[][] data = readExcel(sheetname);
		return data;
	}
	
	@AfterSuite
	public void closeReport() {
		
		extent.flush();
	}
}