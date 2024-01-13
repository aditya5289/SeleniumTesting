package basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingOnDynamicMenus {

	@Test
	public void selectMenu()
	{
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://demo.automationtesting.in/Register.html");
		 driver.manage().window().maximize();
		 
		 Actions builder = new Actions(driver);
		 WebElement menu = driver.findElement(By.linkText("SwitchTo"));
		 builder.moveToElement(menu).perform();
		 
		 List<WebElement> submenus = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li/a"));
		 for(WebElement sb : submenus)
		 {
			 if(sb.getText().equals("Alerts"))
			 {
				 sb.click();
				 break;
			 }
		 }
	}
}
