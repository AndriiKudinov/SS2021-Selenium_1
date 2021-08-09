package pageObjects.BusinessObjects;

import org.testng.Assert;
import pageObjects.HomePage;

public class HomeBO {
    private final HomePage homePage;

    public HomeBO() {
        homePage = new HomePage();
    }

    public HomeBO proceedToHomePage() {
        homePage.proceedToHomePage();
        return this;
    }

    public TrainingListBO clickTrainingListPageButton() {
        homePage.clickTrainingListPageButton();
        return new TrainingListBO();
    }

    public SignInBO clickSignInButton() {
        homePage.clickSignInButton();
        return new SignInBO();
    }

    public BlogBO clickBlogPageButton() {
        homePage.clickBlogPageButton();
        return new BlogBO();
    }

    public HomeBO verifyUserIsLoggedIn(){
        Assert.assertTrue(homePage.isUserNameDisplayed(),
                "User is not logged in");
        return this;
    }
}
