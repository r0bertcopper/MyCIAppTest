import junit.framework.TestCase;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by pmichniuk on 06/07/2017.
 */

public class Selenium extends TestCase {

    public static WebDriver driver;
    public static String baseURL;
    public static WebDriverWait wait;
    private String timeStamp;

    @Before

    public void setUp() throws Exception {

        baseURL = "http://www.compendiumdev.co.uk/selenium";
        driver = setDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();

    }


    public static WebDriver setDriver() {
        /*

        //IE setup

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pmichniuk\\Downloads\\Selenium\\IEDriverServer.exe");

        DesiredCapabilities IECapabilities = DesiredCapabilities.internetExplorer();
        IECapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

        driver = new InternetExplorerDriver(IECapabilities);
        */

        // Chrome setup

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\WebDrivers\\Chrome\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();

        // Pre-exec methods

        driver.manage().window().maximize();

        driver.get(baseURL);

        return driver;
    }


    @org.junit.AfterClass

    public void tearDown() throws Exception

    {
        driver.quit();
    }


    //////////////////////////////
    // ***** GENERIC METHODS ***** //
    //////////////////////////////

    // Static delay
    public static void addDelay(final long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Grab handles
    public String getLastHandle() {
        String lastHandle = "";
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            lastHandle = iterator.next();
        }
        return lastHandle;
    }

    // Get unique timestamp
    public String getUnique() {
        // The unique string is the current time in milliseconds which is 13
        // chars long
        return String.valueOf(System.currentTimeMillis());
    }

    // Get current date
    public String getTodaysDate(final String format) {
        String aFormat = format;

        if (format == "" || format == null) {
            aFormat = "dd/MM/YYYY";
        }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(aFormat);
        return sdf.format(date);
    }

    // Time stamp
    public String timestampGenerator() {
        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyHHmmss");
        this.timeStamp = format.format(curDate);

        return this.timeStamp;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(final String timeStamp) {
        this.timeStamp = timeStamp;
    }

    // Scrolling
    public static boolean scrollElement(WebElement webElement, int scrollPoints) {
        try {
            Actions scroll = new Actions(driver);
            int dragByPixels = 10;
            for (int i = 10; i < scrollPoints; i = i + dragByPixels) {
                scroll.moveToElement(webElement).clickAndHold().moveByOffset(0, dragByPixels).release(webElement).build().perform();
            }
            Thread.sleep(500);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Check if a field is blank
    public static boolean isBlank(String string) {
        int stringLen;
        if (string == null || (stringLen = string.length()) == 0) {
            return true;
        }
        for (int i = 0; i < stringLen; i++) {
            if ((Character.isWhitespace(string.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    //Take a screenshot
    public void takeScreenshot(final String stepName) {

        String currentDate = null;

        File snapShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        currentDate = dateFormat.format(date);
        String time  = timestampGenerator();


        try {
            FileUtils.copyFile(snapShot, new File(
                    "C:\\Selenium\\Screenshots\\" + currentDate + "\\" + stepName + "_" + time + ".png"
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}