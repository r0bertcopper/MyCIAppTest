import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by user on 06/07/2017.
 */
public class TEST3_FRAMES extends Selenium {

    @Test
    public void test_frameSwith() {

        // Navigate to the frames section
        driver.navigate().to(baseURL + "/frames");
        addDelay(5000);
        assertTrue(driver.getTitle().contains("Frameset Example Title"));

        // Switch to the side frame
        driver.switchTo().frame("menu");

        // Click the iFrame link
        driver.findElement(By.xpath("//a[contains(text(),'iFrames Example')]")).click();
        addDelay(3000);

        // Switch to the next frame
        driver.switchTo().frame(driver.findElement(By.xpath("html/body/iframe")));
        addDelay(3000);
        takeScreenshot("iFrame");

       assertEquals("Example 1",driver.findElement(By.xpath("//body/a")).getText());

        // Switch back to default
        driver.switchTo().defaultContent();

        System.out.println("Test Completed");

    }



}
