import consts.BrowserDriverConfigs;
import driver.DriverFactory;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public abstract class BaseTest {

    private Logger LOG = Logger.getLogger(BaseTest.class);
    private Test test;
    static final BrowserDriverConfigs browser = BrowserDriverConfigs.CHROME;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) {
        DriverFactory.initDriver(browser);
        LOG = Logger.getLogger(method.getDeclaringClass());
        test = method.getAnnotation(Test.class);
        LOG.info(String.format("Test '%s' started.",method.getName()));
        LOG.info(String.format("Description: %s.",test.description()));
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(final Method method){
        LOG.info(String.format("Test '%s' completed.",method.getName()));
        DriverFactory.quitDriver();
    }
}