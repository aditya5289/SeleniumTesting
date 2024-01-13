package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UtilMethods {

    public WebDriver LaunchBrowser(String url) {
        // Launch the Chrome browser and navigate to the specified URL
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }

    public static WebElement locateElementById(WebDriver driver, String id) {
        // Locate and return the WebElement by its ID
        return driver.findElement(By.id(id));
    }

    public static void selectCheckBoxByValue(WebDriver driver, String value) {
        // Find all checkboxes with a specific value using CSS selector
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[value='" + value + "']"));

        // Iterate through the checkboxes and select the one with the specified value
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
                break;
            }
        }
    }

    public static void selectRadioByValue(WebDriver driver, String groupName, String value) {
        // Find all radio buttons with the specified group name
        List<WebElement> radios = driver.findElements(By.name(groupName));

        // Iterate through the radio buttons and select the one with the specified value
        for (WebElement radio : radios) {
            if (radio.getAttribute("value").equalsIgnoreCase(value)) {
                radio.click();
                break;
            }
        }
    }

    public static void selectDropDownItemByValue(WebDriver driver, String dropdownName, String value) {
        // Find the dropdown using the given name
        WebElement dropdown = driver.findElement(By.name(dropdownName));

        // Create a Select object for the dropdown
        Select dropdownSelect = new Select(dropdown);

        // Select the dropdown item by its value
        dropdownSelect.selectByValue(value);
    }

    public void selectDropDownItemByText(WebDriver driver, String dropdownName, String text) {
        // Find the dropdown using the given name
        WebElement dropdown = driver.findElement(By.name(dropdownName));

        // Create a Select object for the dropdown
        Select dropdownSelect = new Select(dropdown);

        // Select the dropdown item by its visible text
        dropdownSelect.selectByVisibleText(text);
    }

    public void selectDynamicMenu(WebDriver driver, String mainMenuLinkText, String subMenuText) {
        // Move to the main menu using Actions
        Actions builder = new Actions(driver);
        WebElement mainMenu = driver.findElement(By.linkText(mainMenuLinkText));
        builder.moveToElement(mainMenu).perform();

        // Find and click the desired submenu
        List<WebElement> submenus = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li/a"));
        for (WebElement submenu : submenus) {
            if (submenu.getText().equals(subMenuText)) {
                submenu.click();
                break;
            }
        }
    }

    public String getTableCellData(WebDriver driver, int rownum, int colnum) {
        // Locate the cell in the specified row and column and get the text
        WebElement cell = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + rownum + "]/td[" + colnum + "]"));
        return cell.getText();
    }

    public void clickLinkByText(WebDriver driver, String linkText) {
        // Click the link with the specified text
        driver.findElement(By.linkText(linkText)).click();
    }

    public static void navigateBack(WebDriver driver) {
        // Navigate back in the browser history
        driver.navigate().back();
    }

    public static List<WebElement> getAllLinks(WebDriver driver) {
        // Find and return all the links on the page
        return driver.findElements(By.tagName("a"));
    }
}
