import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class SignInPageTest extends BaseTest {

    @Test(description = "Verify user is successfully logged in with appropriate credentials.")
    public void verifyUserIsSuccessfullyLoggedIn() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("ivanhorintest@gmail.com")
                .clickContinueButton()
                .enterPassword("ivanhorintestPassword")
                .clickSignInButton()
                .verifyUserIsLoggedIn();
    }

    @Test(description = "Verify error message appears when user logging in with inappropriate credentials.")
    public void verifyErrorMessageAppearsForIncorrectUser() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("incorrectmail@gmail.com")
                .clickContinueButton()
                .enterPassword("incorrectPassword")
                .clickSignInButton();
        new SignInPage()
                .verifyFailedLoginErrorMessageDisplayed();

    }

    @Test(description = "Verify the continue button on the ‘Sign In’ window is disabled when incorrect mail is entered.")
    public void verifyContinueButtonDisabledWithInvalidEmail() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("surnamegmail")
                .verifyContinueButtonDisabled();
    }

    @Test(description = "Verify the continue button on the ‘Sign In’ window is enabled with 2 characters in recipient name.")
    public void verifyContinueButtonEnabledWith2CharactersInRecipientName() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("ex@gmail.com")
                .verifyContinueButtonEnabled();
    }

    @Test(description = "Verify the continue button is disabled with verifying all the criteria using hard asserts")
    public void verifyContinueButtonDisabledUsingHardAssets() {
        String email = "@asd";
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .verifyAtSignPresent(email)
                .verifyAtSignIsNotAtTheBeginning(email)
                .enterEmail(email)
                .verifyContinueButtonDisabled();
    }

    @Test(description = "")
    public void verify() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("ivanhorintest@gmail.com")
                .clickContinueButton()
                .enterPassword("ivanhorintestPassword")
                .clickSignInButton();
        new HomePage()
                .verifyUserIsLoggedIn();

    }
}