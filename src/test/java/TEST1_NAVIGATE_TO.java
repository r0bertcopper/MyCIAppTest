/**
 * Created by user on 06/07/2017.
 */
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by pmichniuk on 07/11/2016.
 */
public class TEST1_NAVIGATE_TO extends Selenium {

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


}


