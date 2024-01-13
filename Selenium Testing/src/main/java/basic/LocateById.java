package basic;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocateById {

	@Test
	public void locateById()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
		
		WebElement txtusername = driver.findElement(By.id("txtCustomerID"));
		txtusername.sendKeys("testuser");
		driver.findElement(By.id("txtPassword")).sendKeys("test@113");
		driver.findElement(By.name("Butsub")).click();
		
		WebElement lblError = driver.findElement(By.id("lblMsg"));
		String actError = lblError.getText();
		assertEquals(actError, "Invalid Username/Password");
	}
}
