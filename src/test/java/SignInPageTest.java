import consts.LoginData;
import dataProvider.LoginDataProvider;
import org.testng.annotations.Test;
import pageObjects.BusinessObjects.HomeBO;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class SignInPageTest extends BaseTest {

    @Test(description = "Verify user is successfully logged in with appropriate credentials.")
    public void verifyUserIsSuccessfullyLoggedIn() {
        new HomeBO()
                .login()
                .verifyUserIsLoggedIn();
    }

    @Test(description = "Verify error message appears when user logging in with inappropriate credentials.")
    public void verifyErrorMessageAppearsForIncorrectUser() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(LoginData.EMAIL.getValue())
                .clickContinueButton()
                .enterPassword("incorrectPassword")
                .clickSignInButton();
        new SignInPage()
                .verifyFailedLoginErrorMessageDisplayed();
    }

    @Test(description = "Verify the continue button on the ‘Sign In’ window is disabled when incorrect mail is entered. (Hard Assert)")
    public void verifyContinueButtonDisabledWithInvalidEmailHardAssert() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(LoginData.INVALID_EMAIL.getValue())
                .verifyContinueButtonDisabled();
    }

    @Test(description = "Verify the continue button on the ‘Sign In’ window is disabled when incorrect mail is entered. (Soft Assert)")
    public void verifyContinueButtonDisabledWithInvalidEmailSoftAssert() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(LoginData.INVALID_EMAIL.getValue())
                .verifyContinueButtonDisabledSoftAssert()
                .softAssertAll();
    }

    @Test(description = "Verify the continue button on the ‘Sign In’ window is enabled with valid Boundary value numbers of characters in recipient name.",
            dataProvider = "LoginData", dataProviderClass = LoginDataProvider.class)
    public void verifyContinueButtonEnabledWithValidBoundaryNumberOfCharactersInRecipientName(String email) {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(email)
                .verifyContinueButtonEnabled();
    }

    @Test(description = "Verify previously entered email present after clicking the back button")
    public void verifyEnteredEmailIsPresentAfterClickingBack() {
        String email = LoginData.EMAIL.getValue();
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(email)
                .clickContinueButton()
                .clickBackButton()
                .verifySameEmailPresent(email);
    }
}