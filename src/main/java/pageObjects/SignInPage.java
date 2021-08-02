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

    public SignInPage verifyContinueButtonDisabledSoftAssert() {
        softAssert.assertFalse(isContinueButtonEnabled(),
                "Continue button is enabled");
        return this;
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

    public SignInPage verifyAtSignIsNotPresent(String email) {
        Assert.assertFalse(isAtSignPresent(email),
                "There is '@' in email");
        return this;
    }

    public SignInPage verifyAtSignIsNotPresentSoftAssert(String email) {
        softAssert.assertFalse(isAtSignPresent(email),
                "There is '@' in email");
        return this;
    }

    public boolean isAtSignAtTheBeginning(String email) {
        boolean isAtBeginning = ( email.charAt(0) == '@' );
        LOG.info(String.format("Is @ at the beginning: '%s'", isAtBeginning));
        return isAtBeginning;
    }

    public SignInPage verifyAtSignIsNotAtTheBeginning(String email) {
        Assert.assertFalse(isAtSignAtTheBeginning(email),
                "'@' at the begging of the email");
        return this;
    }

    public SignInPage verifyAtSignIsNotAtTheBeginningSoftAssert(String email) {
        softAssert.assertFalse(isAtSignAtTheBeginning(email),
                "'@' at the begging of the email");
        return this;
    }

    public boolean isDotSymbolPresent(String email) {
        boolean isPresent = email.contains(".");
        LOG.info(String.format("Does email contain '.': '%s'", isPresent));
        return isPresent;
    }

    public SignInPage verifyDotSymbolIsNotPresent(String email) {
        Assert.assertFalse(isDotSymbolPresent(email),
                "Dot symbol is present");
        return this;
    }

    public SignInPage verifyDotSymbolIsNotPresentSoftAssert(String email) {
        softAssert.assertFalse(isDotSymbolPresent(email),
                "Dot symbol is present");
        return this;
    }

    public boolean isRecipientNameMax64Characters(String email) {
        String[] emailArray = email.split("@");
        boolean isEqualOrLessThen64 = ( emailArray[0].length() <= 64 );
        LOG.info(String.format("Is recipient name equal or less then 64 characters: '%s'", isEqualOrLessThen64));
        return isEqualOrLessThen64;
    }

    public SignInPage verifyRecipientNameNotEqualOrLessThen64(String email) {
        Assert.assertFalse(isRecipientNameMax64Characters(email),
                "Recipient name is equal or less then 64 characters");
        return this;
    }

    public SignInPage verifyRecipientNameNotEqualOrLessThen64SoftAssert(String email) {
        softAssert.assertFalse(isRecipientNameMax64Characters(email),
                "Recipient name is equal or less then 64 characters");
        return this;
    }

    public boolean isTopLevelDomainMin2Max10(String email) {
        boolean isMin2Max10 = false;
        String[] emailArray = email.split("@");
        String afterAtSign = emailArray[1];
        if(afterAtSign.contains(".")) {
            String topLevelDomain = afterAtSign.split("\\.")[1];
            isMin2Max10 = (topLevelDomain.length() >= 2 && topLevelDomain.length() <= 10 );
        }
        LOG.info(String.format("Is Top-level-domain in 2-10 range of characters: '%s'", isMin2Max10));
        return isMin2Max10;
    }

    public SignInPage verifyTopLevelDomainNotMin2Max10(String email) {
        Assert.assertFalse(isTopLevelDomainMin2Max10(email),
                "Top-level-domain is in 2-10 range of characters");
        return this;
    }

    public SignInPage verifyTopLevelDomainNotMin2Max10SoftAssert(String email) {
        softAssert.assertFalse(isTopLevelDomainMin2Max10(email),
                "Top-level-domain is in 2-10 range of characters");
        return this;
    }
}