package testProject2;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class IndexPageTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dac.STUDENTSDC\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Set up Chrome options if needed
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless"); // Uncomment this line if you want to run in headless mode
        driver = new ChromeDriver(options);

        // Open the URL
        driver.get("file:///C:/Users/dac.STUDENTSDC/Downloads/index.html");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
           // driver.quit();
        }
    }

    public WebElement waitForElementPresence(WebDriver driver, By locator, int timeoutInSeconds) {
        WebElement element = null;
        int attempts = 0;
        while (attempts < timeoutInSeconds) {
            try {
                element = driver.findElement(locator);
                break;
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                try {
                    Thread.sleep(1000); // Adjust the sleep duration as needed
                } catch (InterruptedException ignored) {
                }
            }
            attempts++;
        }
        return element;
    }

    @Test
    public void testRadioButtonSelection() {
        // Wait for the presence of the radio button
        WebElement maleRadioButton = waitForElementPresence(driver, By.cssSelector("input[name='gender'][value='Male']"), 10);

        // Now interact with the radio button
        if (maleRadioButton != null) {
            maleRadioButton.click();
        } else {
            // Handle the case where the element is not found within the specified timeout
            // You might want to log an error or throw an exception
            System.out.println("Element not found within the specified timeout");
        }

        // Add assertions based on your application state after selecting the radio button
    }

    @Test
    public void testCheckboxSelection() {
        // Select the "Agree to Terms" checkbox
        WebElement agreeCheckbox = driver.findElement(By.id("checkbox"));
        agreeCheckbox.click();

        // Add assertions based on your application state after selecting the checkbox
    }

    @Test
    public void testDropdownSelection() {
        // Select the "Java" option from the dropdown
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Java");

        // Add assertions based on your application state after selecting the dropdown item
    }

    @Test
    public void testLinkNavigation() {
        // Click on the link with id "linkText"
        try {
        	 
    
        	
            WebElement link = driver.findElement(By.id("linkText"));
            System.out.println(link.getText());
            
            link.click(); // Use click() instead of submit() for links
            System.out.println(driver.getTitle());
            
            
        } catch (NoSuchElementException e) {
            // Handle the case where the element is not found
            System.out.println("Link not found: " + e.getMessage());
            fail("Link not found");
        }

        // Add assertions or verifications based on your application state after clicking the link
    }

    @Test
    public void testTableVerification() {
        // Verify the content of the table
        WebElement table = driver.findElement(By.id("customers"));
        // Perform assertions on the table content

        // Add assertions based on your application state after verifying the table
    }

    @Test
    public void testButtonNavigation() {
        // Click on the button with id "submitbtn"
        WebElement button = driver.findElement(By.id("submitbtn"));
        button.click();

        // Add assertions based on your application state after clicking the button
    }

    @Test
    public void testNavigateBack() {
        // Navigate back in the browser history
        driver.navigate().back();

        // Add assertions based on your application state after navigating back
    }

    @Test
    public void testGetAllLinks() {
        // Get all the links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Add assertions based on the number of links or other criteria
        assertTrue(links.size() > 0);
    }

    // Add additional test cases here...

}
