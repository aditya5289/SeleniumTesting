package basic;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingOnLinks {
	WebDriver driver ;
	@BeforeClass
	public void setUp()
	{
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://www.google.com/");
		 driver.manage().window().maximize();
	}
	  @Test
	  public void Gamil() {		  
		  driver.findElement(By.linkText("Gmail")).click();		  
		  String actTitle = driver.getTitle();
		  assertEquals(actTitle, "Gmail: Private and secure email at no cost | Google Workspace");		  
	  }
	  @Test
	  public void images()
	  {  
		  driver.findElement(By.linkText("Images")).click();
		  String actTitle = driver.getTitle();
		  assertEquals(actTitle, "Google Images");
	  }
	  @AfterMethod
	  public void navigateBack()
	  {
		  driver.navigate().back();
	  }
	  
	  @Test
	  public void verifyAllLinks()
	  {
		  List<WebElement> links = driver.findElements(By.tagName("a"));
		  for (WebElement link : links)
		  {
			  System.out.println(link.getText());
		  }
	  }
	  
	  @AfterClass
	  public void tearDown()
	  {
		  driver.close();
	  }
}
