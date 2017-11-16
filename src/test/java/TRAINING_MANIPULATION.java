import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TRAINING_MANIPULATION extends Selenium {

/*
    @Test
    public void test_MyFirstManipulation() {

        // findElement <option value="3">Server</option>
        driver.findElement(By.cssSelector("option[value='3']")).click();
        addDelay(8000);

        // findElement <option value = "23">Java
        driver.findElement(By.cssSelector("option[value='23']")).click();
        addDelay(8000);

        // findElement name = submitButton
        driver.findElement(By.name("submitbutton")).click();
        addDelay(3000);

        // Assert
        assertThat(driver.findElement(By.cssSelector("#_valuelanguage_id")).getText(), is("23"));


    }
*/

    /**
     * Test synchronization using waits
     */

    /*
    new WebDriverWait(driver, 10).until(ExpectedConditons.visibilityOfElementLocated(By.xpath(""))
    */
    @Test
    public void test_expliciWait() {

        driver.get("http://compendiumdev.co.uk/selenium/" + "basic_html_form.html");

        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("HTML Form Elements")); // WebDriverWait pulls periodically

        assertEquals("HTML Form Elements", driver.getTitle());

    }
}