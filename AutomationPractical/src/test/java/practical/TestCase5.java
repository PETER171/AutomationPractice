package practical;

import java.sql.DriverPropertyInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase5 {
	@Test
	public static void test1() throws InterruptedException {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/Drivers/Chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
		
		WebElement ele = driver.findElement(By.xpath("(//div[@class='right-block']//a[contains(text(),Faded)])[1]"));
		//Creating object of an Actions class
		Actions action = new Actions(driver);
		//Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(.,'Proceed to checkout')]")).click();
     	Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='cart_quantity_button clearfix']/a[2]/span[1]")).click();
		driver.findElement(By.xpath("//div[@class='cart_quantity_button clearfix']/a[2]/span[1]")).click();
		driver.findElement(By.xpath("//div[@class='cart_quantity_button clearfix']/a[2]/span[1]")).click();
		Thread.sleep(5000);
		String unitP = driver.findElement(By.xpath("(//span[@class='price'])[2]")).getText();
		String quantity = driver.findElement(By.xpath("//input[@class='cart_quantity_input form-control grey']")).getAttribute("value");
		Thread.sleep(3000);
		System.out.println(quantity);
		String p = unitP.replace("$", "");
		System.out.println(p);
		double str1 = Double.parseDouble(p);
		int str2 = Integer.parseInt(quantity);
		System.out.println(CalculateTotal(str1,str2));
		System.out.println("===============================");
		Thread.sleep(5000);		
		String total = driver.findElement(By.xpath("//td[@class='cart_total']/span[@class='price']")).getText();
		String removeDollar = total.replace("$", "");
		System.out.println(removeDollar);
		double t = Double.parseDouble(removeDollar);
		Thread.sleep(3000);
		if(CalculateTotal(str1,str2)==t) {
			System.out.println("Total of quantity and their price is equal the total calculated");
		}
		else {
			System.out.println("Error");
		}
		driver.close();
		
	}
	
	public static double CalculateTotal(double unitP,int quantity) {
		return unitP * quantity;
	}
}
