package driver;

import consts.BrowserDriverConfigs;
import consts.UtilityConfigs;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public abstract class DriverFactory {

    private static final Logger LOG = Logger.getLogger(DriverFactory.class);

    private static WebDriver webDriver;

    private DriverFactory() {}

    public static void initDriver(BrowserDriverConfigs browser) {
        System.setProperty(browser.getName(), browser.getDriverLocation());

        switch (browser) {
            case CHROME:
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:
                webDriver = new FirefoxDriver();
                break;
            case EDGE:
                webDriver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser is not supported");
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(UtilityConfigs.IMPLICITLY_WAIT_VALUE.getValue(), TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        if(webDriver == null) {
            LOG.info("You are trying to access not existing web driver. Default web driver created.");
            initDriver(BrowserDriverConfigs.CHROME);
        }
        return webDriver;
    }

    public static void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver=null;
        }
    }
}