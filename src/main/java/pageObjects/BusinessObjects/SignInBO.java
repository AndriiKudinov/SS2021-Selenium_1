package pageObjects.BusinessObjects;

import consts.LoginData;
import org.testng.Assert;
import pageObjects.SignInPage;

public class SignInBO extends AbstractBO{
    private final SignInPage signInPage;

    public SignInBO() {
        signInPage = new SignInPage();
    }

    public HomeBO login() {
        signInPage
                .enterEmail(LoginData.EMAIL.getValue())
                .clickContinueButton()
                .enterPassword(LoginData.PASSWORD.getValue())
                .clickSignInButton();
        return new HomeBO();
    }

    public SignInBO enterEmail(String email) {
        signInPage.enterEmail(email);
        return this;
    }

    public SignInBO clickContinueButton() {
        signInPage.clickContinueButton();
        return this;
    }

    public SignInBO enterPassword(String password) {
        signInPage.enterPassword(password);
        return this;
    }

    public HomeBO clickSignInButton() {
        signInPage.clickSignInButton();
        return new HomeBO();
    }

    public SignInBO verifyFailedLoginErrorMessageDisplayed(){
        Assert.assertTrue(signInPage.isLoginFailedErrorMessageDisplayed(),
                "'Login failed' error message is not displayed");
        return this;
    }

    public SignInBO verifyContinueButtonEnabled() {
        Assert.assertTrue(signInPage.isContinueButtonEnabled(),
                "Continue button is disabled");
        return this;
    }

    public SignInBO verifyContinueButtonDisabled() {
        Assert.assertFalse(signInPage.isContinueButtonEnabled(),
                "Continue button is enabled");
        return this;
    }

    public SignInBO verifyContinueButtonDisabledSoftAssert() {
        softAssert.assertFalse(signInPage.isContinueButtonEnabled(),
                "Continue button is enabled");
        softAssertAll();
        return this;
    }

    public SignInBO clickBackButton() {
        signInPage.clickBackButton();
        return this;
    }

    public SignInBO verifyTheSameEmailIsPresent(String email) {
        Assert.assertTrue(signInPage.isSameEmailPresent(email),
                "Previously entered email is not present");
        return this;
    }
}
