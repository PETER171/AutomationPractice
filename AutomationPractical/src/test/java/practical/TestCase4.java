package practical;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase4 {
		
	
	@Test
	public static void test1() throws InterruptedException {

		String username  = "useremail";
		String password  = "userpassword";
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/Drivers/Chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(.,'Sign in')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(.,'Sign in')]")).click();
		Thread.sleep(3000);
		driver.close();
		
	}
}
