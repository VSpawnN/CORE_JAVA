package VishalJadhav;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class DataDrivenTest {
	
	String xlPath = "C:\\SELENIUM-WORKSPACE\\ExcelDriven.xlsx";
	
	WebDriver driver;
	
	//@BeforeTest
	public ArrayList<String> FetchData(String testCaseName) throws IOException
	{
		ArrayList<String> arr = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(xlPath);
		XSSFWorkbook ExcelWorkBook = new XSSFWorkbook(fis);
		int sheetNum = ExcelWorkBook.getNumberOfSheets();
		for(int i=0;i < sheetNum;i++)
			if(ExcelWorkBook.getSheetName(i).equalsIgnoreCase("Parameters"))
			{
				XSSFSheet sheets = ExcelWorkBook.getSheetAt(i);
				//identify the testcases column in the Parameters Sheet.
				Iterator<Row> rows = sheets.iterator();// creating object of iterator to start with the row
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.cellIterator(); // creating object of iterator of firstrow as cells to iterator to check for Testcases
				int k = 0;
				int column = 0;
				while(cells.hasNext()) //Loop for getting the Cells Data to find Testcases column
				{
					Cell Value = cells.next(); //creating the cell object to check for the Testcases column.
					if(Value.getStringCellValue().equalsIgnoreCase("Testcases")) //To get the column number for the TestCases Column
						column = k;
					k++;
				}
				//System.out.println(column);
				while(rows.hasNext()) //Loop for getting the TestCase Name as "Login"
				{
					Row r = rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName))
					{
						Iterator<Cell> cv = r.cellIterator();
						cv.next();
						while(cv.hasNext()) //Loop for getting Parameters for respective Testcases "Login"
						{
							Cell cType = cv.next();
							if(cType.getCellType().toString().equalsIgnoreCase("STRING"))
								arr.add(cType.getStringCellValue());	
							else
								arr.add(NumberToTextConverter.toText(cType.getNumericCellValue()));					
						}
					}
				}
			}
		return arr;
	}
	
	@Test
	public void Login() throws IOException, InterruptedException
	{
		ArrayList<String> arr = FetchData("Login");
		String parameter1 = arr.get(0);
		String parameter2 = arr.get(1);
		
		System.setProperty("webdriver.chrome.driver","C:\\SELENIUM-WORKSPACE\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://yahoo.com");
		driver.findElement(By.cssSelector("a[id='ysignin']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-username']")));
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys(parameter1);
		driver.findElement(By.xpath("//input[@id='login-signin']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-passwd']")));
		driver.findElement(By.xpath("//input[@id='login-passwd']")).sendKeys(parameter2);
		driver.findElement(By.xpath("//button[@id='login-signin']")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[id='ysignout']")));
		//driver.findElement(By.cssSelector("a[id='ysignout']")).click();
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void driverClose() 
	{
		driver.quit();
		
	}
}
