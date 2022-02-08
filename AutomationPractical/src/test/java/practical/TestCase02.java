package practical;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase02 {
	@Test
	public static void test2() throws InterruptedException 
	{
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/Drivers/Chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='search_query_top']")).click();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("Shoes");
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[@name='submit_search']")).click();
//		Thread.sleep(10000);
		String searchCriteria = "shoes,dress,jeans";
		String[] myArrStrings = searchCriteria.split(",");
		for (int x = 0; x<myArrStrings.length;x++)
		{
			System.out.println(myArrStrings[x]);
			driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(myArrStrings[x]);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@name='submit_search']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//input[@id='search_query_top']")).clear();
			Thread.sleep(3000);
		}
		
		
		driver.close();
	}
		
}
