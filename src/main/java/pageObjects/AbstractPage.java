package pageObjects;

import consts.UtilityConfigs;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AbstractPage {

    private WebDriverWait wait =  new WebDriverWait(DriverFactory.getDriver(), UtilityConfigs.IMPLICITLY_WAIT_VALUE.getValue());

    AbstractPage() {
    }

    void  proceedToPage(final String url) {
        DriverFactory.getDriver().get(url);
    }

    WebElement getElement(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement;
    }

    List<WebElement> getElements(By locator) {
        return DriverFactory.getDriver().findElements(locator);
    }


    public boolean isDisplayed(By locator) {
        try {
            return getElement(locator)
                    .isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public boolean isEnabled(By locator) {
        try {
            return getElement(locator)
                    .isEnabled();
        } catch (NoSuchElementException | TimeoutException exception) {
            return false;
        }
    }
}