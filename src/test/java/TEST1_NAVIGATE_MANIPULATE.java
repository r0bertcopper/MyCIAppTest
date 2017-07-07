/**
 * Created by user on 06/07/2017.
 */

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by pmichniuk on 07/11/2016.
 */
public class TEST1_NAVIGATE_MANIPULATE extends Selenium {

    //public static InternetExplorerDriver driver;

    @Test
    public void test_NavigateTo_AssertTitle() {

        //Vars
        String searchPhrase = "Test Heavily";

        // Locators
        String searchButton = "body > form > input[type=\"submit\"]:nth-child(2)";


        //Step 1 - Move Home --> Search Engine
        driver.navigate().to(baseURL + "/search.php");
        addDelay(5000);

        //Take a screenshot to confirm
        takeScreenshot("Search Engine");
        addDelay(2000);

        // Assert against the title
        assertTrue(driver.getTitle().contains("Search Engine"));

        // Refresh the page as sometimes loads slowly first time
        driver.navigate().refresh();

        // Wait for the search box to be loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/input[1]"))).clear();
        addDelay(5000);

        // Enter a phrase
        driver.findElement(By.xpath("/html/body/form/input[1]")).sendKeys(searchPhrase);
        addDelay(2000);

        // Click the "Search Button"
        driver.findElement(By.cssSelector(searchButton)).click();
        addDelay(10000);

        System.out.println("End of Test");
    }


    @Test
    public void test_formFill() {

        // Locators
        String cancelButton = ".//*[@id='HTMLFormElements']/table/tbody/tr[1]/td/input";
        String userNameField = ".//*[@id='HTMLFormElements']/table/tbody/tr[1]/td/input";
        String passWordField = "//tr[2]/td/input";
        String commentsTextArea = ".//*[@id='HTMLFormElements']/table/tbody/tr[3]/td/textarea";
        String checkBoxItem1 = "html/body/form/table/tbody/tr[5]/td/input[1]";
        String dropDown = ".//*[@id='HTMLFormElements']/table/tbody/tr[8]/td/select";
        String dropOpt = "//*[contains(text(), 'Drop Down Item 5')]";
        String dropChoice = "   Drop Down Item 2 ";
        String submitButton = ".//*[@id='HTMLFormElements']/table/tbody/tr[9]/td/input[2]";
        String goBackLink = "back_to_form";

        // Variables
        String userName = "user1";
        String passWord = "passw0rT";
        String comText = "Test";

        // Go to the web page
        driver.navigate().to(baseURL + "/basic_html_form.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cancelButton)));

        // Enter "username"
        driver.findElement(By.xpath(userNameField)).clear();
        addDelay(2000);
        driver.findElement(By.xpath(userNameField)).sendKeys(userName);
        addDelay(3000);

        // Enter password
        driver.findElement(By.xpath(passWordField)).clear();
        addDelay(2000);
        driver.findElement(By.xpath(passWordField)).sendKeys(passWord);
        addDelay(3000);

        // Add some comments
        driver.findElement(By.xpath(commentsTextArea)).clear();
        addDelay(2000);
        driver.findElement(By.xpath(commentsTextArea)).sendKeys(comText);
        addDelay(3000);

        // Tick Checkbox 1
        List<WebElement> tickBoxes = driver.findElements(By.name("checkboxes[]"));
        for (WebElement tickBox : tickBoxes) {

            if (tickBox.getAttribute("value").contentEquals("cb1")) {

                tickBox.click();
            }

        }
        addDelay(3000);

        // Select an option from the drop down menu
        // Click the drop down
        driver.findElement(By.xpath(dropDown)).click();
        driver.findElement(By.xpath(dropDown)).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath(dropDown)).sendKeys(Keys.ENTER);
        addDelay(3000);

        // Click a radio button
        List<WebElement> radioButtons = driver.findElements(By.name("radioval"));
        for (WebElement radioBut : radioButtons) {

            if (radioBut.getAttribute("value").contentEquals("rd1")) {

                Actions clickRadio1 = new Actions(driver).click(radioBut);
                clickRadio1.perform();
                addDelay(3000);
            }

        }

        // Click "Submit"
        driver.findElement(By.xpath(submitButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(goBackLink)));


    }


}


