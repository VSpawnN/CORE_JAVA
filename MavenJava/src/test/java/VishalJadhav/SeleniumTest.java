package VishalJadhav;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SeleniumTest {
	ExtentReports reports;
	
	

	@Test
	public void BrowserAutomation() throws InterruptedException
	{
		reports.createTest("BrowserAutomationTest");
		System.setProperty("webdriver.chrome.driver","C:\\SELENIUM-WORKSPACE\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com");
		Thread.sleep(5000);
		driver.close();
		//reports.flush();
	}
	
	
	@Test
	public void ElementsUI() throws InterruptedException
	{
		ExtentTest test = reports.createTest("ElementsUITest");
		System.setProperty("webdriver.chrome.driver","C:\\SELENIUM-WORKSPACE\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.JavaTpoint.com");
		//String url = driver.getCurrentUrl();
		Thread.sleep(5000);
		driver.close();
		test.fail("Results do not match");
		reports.flush();
	}
	
	@BeforeTest
	public void configuration()
	{
		String srcPath = System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(srcPath);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Vishal Executions Results");
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Tester","Vishal Jadhav");
	}

}
