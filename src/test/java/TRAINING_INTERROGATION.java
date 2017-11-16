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


/**
 * get
 * Created by user on 13/08/2017.
 */
public class TRAINING_INTERROGATION extends Selenium {
/*
    @Test
    public void test_InterrogateTraining() throws Exception {

        driver.navigate().to(baseURL);

        addDelay(10000);

        assertEquals(driver.getTitle(), "Basic Web Page Title");
        assertEquals(driver.getCurrentUrl(), baseURL);

        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("A paragraph of text"));

        System.out.println(pageSource);
    }
*/
/*
    @Test
    public void test_InterrogateTraining2() throws Exception {

        final String part2URL = "www.compendiumdev.co.uk/selenium/find_by_playground.php";

        driver.navigate().to(baseURL);
        addDelay(3000);

        //Part 1

        WebElement para1 = driver.findElement(By.id("para1"));
        assertEquals(para1.getText(),"A paragraph of text");
        addDelay(3000);

        // Part 2

        driver.navigate().to(part2URL);
        addDelay(3000);
        assertThat(driver.findElement(By.id("p3")).getText(), is("This is c paragraph text"));
    }
*/
/*
    @Test
    public void test_returnAListOfElementsByClassName() {

        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/find_by_playground.php");

        List<WebElement> elements;
        elements = driver.findElements(By.className("normal"));

        Set<String>  foundTags = new HashSet<String> ();

        for (WebElement e : elements) {

            foundTags.add(e.getTagName());
        }

        System.out.println(elements);

        assertTrue("expected p tag", foundTags.contains("p"));
        assertTrue("expected ul tag", foundTags.contains("ul"));
        assertTrue("expected li tag", foundTags.contains("li"));
        assertTrue("expected a tag", foundTags.contains("a"));
        assertFalse("did not expect div tag", foundTags.contains("div"));


    }
*/
/*
    @Test
    public void test_returnAListOfElementsByClassName() {

        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/find_by_playground.php");

        List<WebElement> elements;
        elements = driver.findElements(By.xpath("//*[contains(@href, '#pName')]"));

        Set<String>  foundTags = new HashSet<String> ();

        for (WebElement e : elements) {

            foundTags.add(e.getTagName());
        }

        System.out.println(elements.size());

        assertEquals(elements.size(),25);
    }
*/
/*
    @Test
    public void test_returnAListOfElementsByClassName() {

        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/find_by_playground.php");

        List<WebElement> elements;
        elements = driver.findElements(By.tagName("div"));

        Set<String>  foundTags = new HashSet<String> ();

        for (WebElement e : elements) {

            foundTags.add(e.getTagName());
        }

        System.out.println(elements.size());

        assertEquals(elements.size(),19);
    }
*/

    /**
     * Nested paragraphs
     */
/*
    @Test
    public void test_assertNestedParagraphs() {

    driver.navigate().to("http://www.compendiumdev.co.uk/selenium/find_by_playground.php");

    List<WebElement> elements;
    elements = driver.findElements(By.tagName("p"));

    Set<String>  foundTags = new HashSet<String> ();

    int nestedParas = 0;
    for (WebElement e : elements) {

        if (e.getText().contains("nested para")){

            nestedParas++;
        }
    }

    System.out.println(nestedParas);

    assertEquals(nestedParas,16);
}
*/

/*
    @Test
    public void test_assertNestedParagraphs() {

        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/find_by_playground.php");

        WebElement element = driver.findElement(
                new ByChained(
                        By.id("div1"),
                        By.name("pName9"),
                        By.tagName("a")));


        assertEquals("expected a different id", "a9", element.getAttribute("id"));
    }

*/

    /**
     * A good supporting class
     */
/*
    @Test
    public void test_findByIdOrNameMatchOnName() {

        WebElement element;
        element = driver.findElement(new ByIdOrName("pName2"));

        assertEquals("expected a match on name", "This is b paragraph text",
                element.getText());

    }

    @Test
    public void test_findByIdOrNameMatchOnId() {

        WebElement element;
        element = driver.findElement(new ByIdOrName("p3"));

        assertEquals("expected a match on id", "This is c paragraph text",
                element.getText());

    }
*/

    /**
     * cssSelectors allow for more flexibility whenever a web page changes i.e. id changes
     * or position of an element on the web page changes
     * cssSelectors provide a higher degree of flexibility
     */
/*
    @Test
    public void findByIdUsingCSSId() {

        WebElement element;
        element = driver.findElement(By
                .cssSelector("#p3"));

        assertEquals("expected a match on id",
                "This is c paragraph text",
                element.getText());

    }
*/
/*
    @Test
    public void test_findByCSSDataDriven() {

        class TestData {

            public String css;
            public String name;
            public String value;
            public String alt;

            public TestData(String css, String name, String value, String alternativeTo){

                this.css = css;
                this.name = name;
                this.value = value;
                this.alt = alternativeTo;

            }

        }

        List<TestData> dataItems = Arrays.asList(

                new TestData("#p31", "name", "pName31", "By.id(\"p31\")"),
                new TestData ("[id = 'p31']", "name", "pName31", "By.id(\"p31\")")

        );

        WebElement element;

        for(TestData dataItem : dataItems){

            element = driver.findElement(By.cssSelector((dataItem.css)));

            System.out.println(String.format("Instead of %s use By.cssSelector (\"%s\")",
                    dataItem.alt, dataItem.css.replaceAll("\"", "\\\\\"")));

            assertThat(element.getAttribute(dataItem.name), is(dataItem.value));
        }

    }

*/
/*
    @Test
    public void test_directDescendant() {


        assertEquals("div > p", 41, driver.findElements(By.cssSelector("div > p")).size());

        assertEquals("div > li", 0, driver.findElements(By.cssSelector("div > li")).size());

    }


    @Test
    public void test_anyDescendant() {


        assertEquals("div p", 41, driver.findElements(By.cssSelector("div p")).size());

        assertEquals("div li", 25, driver.findElements(By.cssSelector("div li")).size());

    }

    @Test
    public void test_siblingOfPreceding() {

        assertEquals("li + li", 24, driver.findElements(By.cssSelector("li + li")).size());

        assertEquals("li", 25, driver.findElements(By.cssSelector("li")).size());


    }

    @Test
    public void test_firstChild() {

        assertEquals("li:first-child", 1, driver.findElements(By.cssSelector("li:first-child")).size());

    }
*/
    @Test
    public void test_FindElementByXpath() {

        assertTrue(driver.findElement(By.xpath("//*[@id='p31']")).isDisplayed());
        addDelay(2000);

        assertTrue(driver.findElement(By.xpath("//*[starts-with(@name, 'ulName1'] and string-lenght(@name)=7]")).isDisplayed());
        WebElement wait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'a29'")));



        driver.findElement(By.xpath("//*[@id='a29']")).click();
        System.out.println("Link has been clicked.");
        addDelay(5000);


    }



}
