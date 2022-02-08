package practical;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase6 {
	@Test
	public static void test1() throws InterruptedException {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/Drivers/Chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//a[.='Women']"));
		//Creating object of an Actions class
		Actions action = new Actions(driver);
		//Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();	
		
		driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[@class='sfHover']//a[.='T-shirts']")).click();
		Thread.sleep(10000);
		
		if(driver.findElement(By.xpath("//span[@class='cat-name']")).isDisplayed()) {
			System.out.println("This is the right page");
		}
		
		driver.close();
		
	}
}
