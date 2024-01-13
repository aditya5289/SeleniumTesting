package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class LaunchBrowser {
	
  public void launchChrome() {
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://www.google.com/");
	  
	  driver.manage().window().maximize();
	  
	  System.out.println(driver.getTitle());
	  System.out.println(driver.getCurrentUrl());
	  
	  driver.close();
	  
  }
}
