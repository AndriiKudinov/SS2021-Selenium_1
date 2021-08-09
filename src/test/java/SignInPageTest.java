import consts.LoginData;
import dataProvider.DataProviders;
import org.testng.annotations.Test;
import pageObjects.BusinessObjects.HomeBO;
import pageObjects.BusinessObjects.SignInBO;

public class SignInPageTest extends BaseTest {

    @Test(description = "Verify user is successfully logged in with appropriate credentials.")
    public void verifyUserIsSuccessfullyLoggedIn() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login()
                .verifyUserIsLoggedIn();
    }

    @Test(description = "Verify error message appears when user logging in with inappropriate credentials.")
    public void verifyErrorMessageAppearsForIncorrectUser() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(LoginData.EMAIL.getValue())
                .clickContinueButton()
                .enterPassword(LoginData.INCORRECT_PASSWORD.getValue())
                .clickSignInButton();
        new SignInBO()
                .verifyFailedLoginErrorMessageDisplayed();
    }

    @Test(description = "Verify the continue button on the ‘Sign In’ window is disabled when incorrect mail is entered. (Hard Assert)")
    public void verifyContinueButtonDisabledWithInvalidEmailHardAssert() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(LoginData.INVALID_EMAIL.getValue())
                .verifyContinueButtonDisabled();
    }

    @Test(description = "Verify the continue button on the ‘Sign In’ window is disabled when incorrect mail is entered. (Soft Assert)")
    public void verifyContinueButtonDisabledWithInvalidEmailSoftAssert() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(LoginData.INVALID_EMAIL.getValue())
                .verifyContinueButtonDisabledSoftAssert();
    }

    @Test(description = "Verify the continue button on the ‘Sign In’ window is enabled with valid Boundary value numbers of characters in recipient name.",
            dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verifyContinueButtonEnabledWithValidBoundaryNumberOfCharactersInRecipientName(String email) {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(email)
                .verifyContinueButtonEnabled();
    }

    @Test(description = "Verify previously entered email present after clicking the back button")
    public void verifyEnteredEmailIsPresentAfterClickingBack() {
        String email = LoginData.EMAIL.getValue();
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(email)
                .clickContinueButton()
                .clickBackButton()
                .verifyTheSameEmailIsPresent(email);
    }
}