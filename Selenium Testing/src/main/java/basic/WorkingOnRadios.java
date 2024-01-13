package basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingOnRadios {

	@Test
	public void selectRadio()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://echoecho.com/htmlforms10.htm");
		
		List<WebElement> radios = driver.findElements(By.name("group1"));
		for (WebElement rb : radios)
		{
			if(rb.getAttribute("value").equalsIgnoreCase("Milk"))
			{
				rb.click();
				break;
			}
		}
	}
}
