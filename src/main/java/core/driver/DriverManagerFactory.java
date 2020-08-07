package core.driver;


import core.constants.BrowserType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DriverManagerFactory {

    private static final Logger LOGGER = LogManager.getLogger(DriverManagerFactory.class.getName());

    public static DriverManager getManager(BrowserType type) {

        DriverManager driverManager = null;

        switch (type) {
            case CHROME:
                LOGGER.info("Initialize Chrome diver");
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                LOGGER.info("Initialize Firefox diver");
                driverManager = new FirefoxDriverManager();
                break;
        }
        return driverManager;
    }
}
