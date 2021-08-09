package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SignInPage extends AbstractPage{

    private static final Logger LOG = Logger.getLogger(SignInPage.class);

    private final By mailInput = By.id("username");

    private final By passwordInput = By.id("password");

    private final By signInButton = By.id("kc-login");

    private final By continueButton = By.id("kc-login-next");

    private final By loginFailedErrorMessage = By.xpath("//span[text()=\"We can't find user with such credentials.\"]");

    private final By backButton = By.id("kc-login-prev");

    public SignInPage enterEmail(String email){
        getElement(mailInput).sendKeys(email);
        LOG.info(String.format("%s : mail was entered.", email));
        return this;
    }

    public  SignInPage clickContinueButton(){
        getElement(continueButton).click();
        LOG.info("Continue button clicked.");
        return this;
    }

    public SignInPage enterPassword(String password){
        getElement(passwordInput).sendKeys(password);
        LOG.info("Password was entered.");
        return this;
    }

    public HomePage clickSignInButton(){
        getElement(signInButton).click();
        LOG.info("Sign in button is clicked.");
        return new HomePage();
    }

    public boolean isLoginFailedErrorMessageDisplayed() {
        boolean isDisplayed = isDisplayed(loginFailedErrorMessage);
        LOG.info(String.format("Is 'Login Failed' error message displayed: '%s'",isDisplayed));
        return isDisplayed;
    }

    public boolean isContinueButtonEnabled() {
        boolean isEnabled = isEnabled(continueButton);
        LOG.info(String.format("Is 'continue' button enabled: '%s'",isEnabled));
        return isEnabled;
    }

    public SignInPage clickBackButton() {
        getElement(backButton).click();
        LOG.info("'Back' button is clicked.");
        return this;
    }

    public boolean isSameEmailPresent(String email) {
        boolean isPresent = getElement(mailInput).getAttribute("value").equalsIgnoreCase(email);
        LOG.info(String.format("Is previously entered email present : '%s'", isPresent));
        return isPresent;
    }
}