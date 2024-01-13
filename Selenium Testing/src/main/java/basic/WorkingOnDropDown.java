package basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingOnDropDown {

	@Test
	public void selectDropDownItemByValue()
	{
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://echoecho.com/htmlforms11.htm");
		 driver.manage().window().maximize();
		 
		 WebElement dd = driver.findElement(By.name("mydropdown"));
		 Select dditems = new Select(dd);
		 List<WebElement> options = dditems.getOptions();
		 for(WebElement op : options)
		 {
			 if(op.getAttribute("Value").equalsIgnoreCase("Bread"))
			 {
				 dditems.selectByValue("Bread");
				 break;
			 }
		 }
	}
	
	@Test
	public void selectDropDownItemByText()
	{
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://echoecho.com/htmlforms11.htm");
		 driver.manage().window().maximize();
		 
		 WebElement dd = driver.findElement(By.name("mydropdown"));
		 Select dditems = new Select(dd);
		 List<WebElement> options = dditems.getOptions();
		 for(WebElement op : options)
		 {
			 if(op.getText().equalsIgnoreCase("Old Cheese"))
			 {
				 dditems.selectByVisibleText("Old Cheese");
				 break;
			 }
		 }
	}
	
	@Test
	public void selectLanguage()
	{
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://demo.automationtesting.in/Register.html");
		 driver.manage().window().maximize();
		 driver.findElement(By.id("msdd")).click();
		 List<WebElement> langs = driver.findElements(By.cssSelector("a.ui-corner-all"));
		 for (WebElement lang : langs)
		 {
			 if(lang.getText().equalsIgnoreCase("English"))
			 {
				 lang.click();
				 break;
			 }
		 }
	}
	
}
