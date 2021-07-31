package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignInPage extends AbstractPage{

    private static final Logger LOG = Logger.getLogger(SignInPage.class);

    private final By mailInput = By.id("username");

    private final By passwordInput = By.id("password");

    private final By signInButton = By.id("kc-login");

    private final By continueButton = By.id("kc-login-next");

    private final By loginFailedErrorMessage = By.xpath("//span[text()=\"We can't find user with such credentials.\"]");

    public SignInPage enterEmail(String email){
        getElement(mailInput).sendKeys(email);
        LOG.info("Mail was entered.");
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

    public  HomePage clickSignInButton(){
        getElement(signInButton).click();
        LOG.info("Sign in button clicked.");
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

    public void verifyContinueButtonEnabled() {
        Assert.assertTrue(isContinueButtonEnabled(),
                "Continue button is disabled");
    }

    public void verifyContinueButtonDisabled() {
        Assert.assertFalse(isContinueButtonEnabled(),
                "Continue button is enabled");
    }

    public void verifyFailedLoginErrorMessageDisplayed(){
        Assert.assertTrue(isLoginFailedErrorMessageDisplayed(),
                "'Login failed' error message is not displayed");
    }

    public boolean isAtSignPresent(String email) {
        boolean isPresent = email.contains("@");
        LOG.info(String.format("Does email contain @: '%s'", isPresent));
        return isPresent;
    }

    public SignInPage verifyAtSignPresent(String email) {
        Assert.assertTrue(isAtSignPresent(email),
                "There is no '@' in email");
        return this;
    }

    public boolean isAtSignAtTheBeginning(String email) {
        boolean isAtBeginning = ( email.charAt(0) == '@' );
        LOG.info(String.format("Is @ at the beginning: '%s'", isAtBeginning));
        return isAtBeginning;
    }

    public SignInPage verifyAtSignIsNotAtTheBeginning(String email) {
        Assert.assertFalse(isAtSignAtTheBeginning(email), "'@' at the begging of the email");
        return this;
    }
}