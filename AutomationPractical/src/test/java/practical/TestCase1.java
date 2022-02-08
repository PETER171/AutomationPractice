package practical;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase1 {
	@Test
	public static void test1() throws InterruptedException {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/Drivers/Chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='search_query_top']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("Shoes");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='submit_search']")).click();
		Thread.sleep(10000);
		driver.close();
		
	}
}
