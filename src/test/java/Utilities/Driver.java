package Utilities;

import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Driver {

    private WebDriver webDriver;
    private String fileName;
    private String folder;

    public Driver() {

    }

    public Driver(Properties prop) {

        this.webDriver = new DriverFactory().getDriver(prop.getProperty("browser"));
        this.webDriver.get(prop.getProperty("application_url"));
        // this.webDriver.get("https://www.flipkart.com/");
        this.webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        folder = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }
}
