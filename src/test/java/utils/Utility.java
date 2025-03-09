package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Utility {

	public static WebDriver driver;
	public static Properties prop;
	public String sheetname;
	public String filepath;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName, testDescription, testCategory, testAuthor;

	public static void launchAndLoadUrl(String url, String browser)  {

		// cross-browser testing
		if (browser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		} else {

			driver = new ChromeDriver();

		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Thread.sleep(1000);

	}

	public static void closingBrowser() {

		driver.close();
	}

	public static void hardAssertCheck(String acc, String exp) {

		Assert.assertEquals(acc, exp);
	}

	public static String[][] readExcel(String sheetname) throws Exception {

		XSSFWorkbook book = new XSSFWorkbook(
				"C:\\Users\\Pradeep\\eclipse-workspace\\OrangeHRM\\src\\test\\resources\\data\\OrangeHRMTestdata.xlsx");
		XSSFSheet sheet = book.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		short columncount = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[rowcount][columncount];
		for (int i = 1; i <= rowcount; i++) {

			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < columncount; j++) {

				XSSFCell cell = row.getCell(j);
				System.out.println(cell.getStringCellValue());
				data[i - 1][j] = cell.getStringCellValue();

			}
		}
		book.close();
		return data;
	}

	public static void readFromPropFile(String filepath) throws IOException {

		FileReader file = new FileReader(filepath);
		prop = new Properties();
		prop.load(file);
	}

	public static String screenshot(String name) throws IOException {

		String path = "C:\\Users\\Pradeep\\eclipse-workspace\\OrangeHRM\\screenshot\\" + name + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
}