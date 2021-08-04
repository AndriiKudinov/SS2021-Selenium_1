package pageObjects.BusinessObjects;

import consts.LoginData;
import org.testng.Assert;
import pageObjects.HomePage;

public class HomeBO {
    private final HomePage homePage;

    public HomeBO() {
        homePage = new HomePage();
    }

    public HomeBO login() {
        homePage
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(LoginData.EMAIL.getValue())
                .clickContinueButton()
                .enterPassword(LoginData.PASSWORD.getValue())
                .clickSignInButton();
        return this;
    }

    public HomeBO verifyUserIsLoggedIn(){
        Assert.assertTrue(homePage.isUserNameDisplayed(),
                "User is not logged in");
        return this;
    }
}
