import org.junit.Test;

/**
 * Created by user on 06/07/2017.
 */
public class TEST2_INTERROGATE extends Selenium {

    String testURL = "http://www.compendiumdev.co.uk/selenium/basic_web_page.html";

    @Test
    public void test_InterrogateWebPage() {

        driver.navigate().to(testURL);

        assertEquals(driver.getTitle(),"Basic Web Page Title");
        assertEquals(driver.getCurrentUrl(),testURL);

    }


}
