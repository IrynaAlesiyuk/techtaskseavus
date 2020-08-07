package utils;


import core.constants.Browsers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageMethods.SubmittedFormPageMethods;

import static core.constants.Browsers.CHROME;
import static core.constants.Browsers.FIREFOX;

public class DriversManager {

    private static final Logger LOGGER = LogManager.getLogger(DriversManager.class.getName());

    public WebDriver driver;

    public WebDriver initBrowser(Browsers browser) {
        if (browser.equals(CHROME)) {
            System.setProperty("webdriver.chrome.driver", PropertiesManager.propFile("chromeDriverPath"));
            LOGGER.info("Initialize Chrome diver");
            driver = new ChromeDriver();

        } else if (browser.equals(FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", PropertiesManager.propFile("firefoxDriverPath"));
            LOGGER.info("Initialize Firefox diver");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }
}
