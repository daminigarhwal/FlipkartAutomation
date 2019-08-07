package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {


    private WebDriver driver;
    private ChromeOptions options = null;

    public WebDriver getDriver(String browserType) {

        if (browserType.equalsIgnoreCase("Chrome")) {

            // EDIT THE LOCATION OF CHROME AND OTHER DRIVERS ... CAN BE LIKE "...../esources/Drivers/chromedriver"
            options = new ChromeOptions();
            options.addArguments("chrome.switches", "--ignore-certificate-errors", "--disable-popup-blocking", "--disable-translate", "--disable-extensions");
            System.setProperty("webdriver.chrome.driver", "");
            driver = new ChromeDriver(options);

        } else if (browserType.equalsIgnoreCase("Firefox")) {

            // EDIT THE LOCATION OF CHROME AND OTHER DRIVERS ... CAN BE LIKE "...../esources/Drivers/firefoxdriver"
            System.setProperty("webdriver.firefox.marionette", "");
            driver = new FirefoxDriver();

        } else if (browserType.equalsIgnoreCase("Headless")) {

            // EDIT THE LOCATION OF CHROME AND OTHER DRIVERS ... CAN BE LIKE "...../esources/Drivers/chromedriver"
            System.setProperty("webdriver.chrome.driver", "");
            options = new ChromeOptions();
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");
            driver = new ChromeDriver(options);

        } else if (driver == null) {
            throw new IllegalArgumentException("no driver was provided in the configuration.properties file");
        }

        return driver;
    }
}
