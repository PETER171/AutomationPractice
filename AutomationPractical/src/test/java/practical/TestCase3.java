package practical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class TestCase3 {
	@Test
	public static void test3() throws InterruptedException {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/Drivers/Chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='search_query_top']")).click();
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(readExcel().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='submit_search']")).click();
		Thread.sleep(10000);
		driver.close();
		
	}
	
	public static XSSFCell readExcel() throws IOException{
		FileInputStream fs = new FileInputStream("/Users/leratopeterkhambulo/eclipse-workspace/AutomationPractical/src/test/TestData.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		//String x = sheet.getRow(1).getCell(1);
		return sheet.getRow(1).getCell(1);
	
		}
	
}
