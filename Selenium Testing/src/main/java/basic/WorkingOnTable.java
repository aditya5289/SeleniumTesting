package basic;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingOnTable {

	@Test
	public void verifyCellData()
	{
		 int rownum = 3;
		 int colnum = 2;
		 String exp = "Francisco Chang";
		 
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		 driver.manage().window().maximize();
		 
		 WebElement cell = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+rownum+"]"
		 		+ "/td["+colnum+"]"));
		 String act = cell.getText();
		 assertEquals(act, exp);
	}
}
