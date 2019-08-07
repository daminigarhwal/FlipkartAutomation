package TestCases;

import Pages.TestPage;
import Utilities.Driver;
import Utilities.PropertyParser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class Test {

    private String configFile = "configuration.properties";
    private Driver driver;
    private Properties properties;
    private SoftAssert softAssert;
    private TestPage testPage;

    @BeforeTest
    public void setUp() throws Exception {
        PropertyParser propertyParser = new PropertyParser();
        this.properties = propertyParser.parseProperties(configFile);
        this.driver = new Driver(this.properties);
        this.softAssert = new SoftAssert();
        this.testPage = new TestPage(this.driver.getWebDriver());
    }


    @org.testng.annotations.Test
    public void doLogin() throws InterruptedException {

        this.testPage.getLoginNumber().sendKeys(this.properties.getProperty("phoneNumber"));
        this.testPage.getLoginPassword().sendKeys(this.properties.getProperty("password"));
        this.testPage.getLoginBtn().submit();

        this.softAssert.assertTrue(this.driver.getWebDriver().getCurrentUrl().contains(this.properties.getProperty("application_url")), "Flipkart page did not load.");
        this.softAssert.assertTrue(this.driver.getWebDriver().getTitle().contains(this.properties.getProperty("title")), "Page does not show the Flipkart title.");

        Thread.sleep(5000);
        this.testPage.getSearchBox().click();
        Thread.sleep(3000);

        this.testPage.getSearchBox().sendKeys(this.properties.getProperty("searchElement"));
        this.testPage.getSearchBtn().click();

        Thread.sleep(3000);

        this.softAssert.assertTrue(this.driver.getWebDriver().getCurrentUrl().contains(this.properties.getProperty("searchElement")), "Page for mobile search did not open.");

        String listPrice = this.testPage.getListPrice().getText();

        this.testPage.getMobileImage().click();

        Set<String> windowids = this.driver.getWebDriver().getWindowHandles();
        Iterator<String> itr = windowids.iterator();

        String mainWindow = itr.next();
        String childwindow = itr.next();

        this.driver.getWebDriver().switchTo().window(childwindow);

        Thread.sleep(2000);

        this.softAssert.assertTrue(listPrice.contains(this.testPage.getProductPrice().getText()), "Price of item on list page and details page is not same.");

        this.softAssert.assertTrue(this.testPage.getProdctDesc().getText().contains(this.properties.getProperty("mobileName")), "Product details are not the same on List page and Details Page.");

        this.testPage.getProfileBtn().click();

        Actions action = new Actions(this.driver.getWebDriver());
        WebElement element = this.testPage.getLinkLogout();
        action.moveToElement(element).perform();

        Thread.sleep(1000);

        this.testPage.getLogoutBtn().click();

        softAssert.assertAll();
    }

    @AfterTest
    public void quitDriver() {
        this.driver.getWebDriver().quit();
    }

}
