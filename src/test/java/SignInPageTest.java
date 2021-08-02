import consts.Constants;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class SignInPageTest extends BaseTest {

    @DataProvider(name = "LoginData")
    public Object[][] getData() {
        return new String[][]{
                {Constants.LogConfigs.CHAR1_EMAIL},
                {Constants.LogConfigs.CHAR2_EMAIL},
                {Constants.LogConfigs.CHAR63_EMAIL},
                {Constants.LogConfigs.CHAR64_EMAIL},
        };
    }

    @Test(description = "Verify user is successfully logged in with appropriate credentials.")
    public void verifyUserIsSuccessfullyLoggedIn() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(Constants.LogConfigs.EMAIL)
                .clickContinueButton()
                .enterPassword(Constants.LogConfigs.PASSWORD)
                .clickSignInButton()
                .verifyUserIsLoggedIn();
    }

    @Test(description = "Verify error message appears when user logging in with inappropriate credentials.")
    public void verifyErrorMessageAppearsForIncorrectUser() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(Constants.LogConfigs.EMAIL)
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

    @Test(description = "Verify the continue button on the ‘Sign In’ window is enabled with valid Boundary value numbers of characters in recipient name.",
            dataProvider = "LoginData")
    public void verifyContinueButtonEnabledWithValidBoundaryNumberOfCharactersInRecipientName(String email) {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(email)
                .verifyContinueButtonEnabled();
    }

    @Test(description = "Verify the continue button is disabled with verifying all the criteria using hard asserts")
    public void verifyContinueButtonDisabledUsingHardAssets() {
        String invalidEmail = Constants.LogConfigs.INVALID_EMAIL;
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .verifyAtSignIsNotPresent(invalidEmail)
                .verifyAtSignIsNotAtTheBeginning(invalidEmail)
                .verifyDotSymbolIsNotPresent(invalidEmail)
                .verifyRecipientNameNotEqualOrLessThen64(invalidEmail)
                .verifyTopLevelDomainNotMin2Max10(invalidEmail)
                .enterEmail(invalidEmail)
                .verifyContinueButtonDisabled();
    }

    @Test(description = "Verify the continue button is disabled with verifying all the criteria using soft asserts")
    public void verifyContinueButtonDisabledUsingSoftAssets() {
        String invalidEmail = Constants.LogConfigs.INVALID_EMAIL;
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .verifyAtSignIsNotPresentSoftAssert(invalidEmail)
                .verifyAtSignIsNotAtTheBeginningSoftAssert(invalidEmail)
                .verifyDotSymbolIsNotPresentSoftAssert(invalidEmail)
                .verifyRecipientNameNotEqualOrLessThen64SoftAssert(invalidEmail)
                .verifyTopLevelDomainNotMin2Max10SoftAssert(invalidEmail)
                .enterEmail(invalidEmail)
                .verifyContinueButtonDisabledSoftAssert()
                .softAssertAll();
    }
}