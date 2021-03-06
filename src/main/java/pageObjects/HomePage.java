package pageObjects;

import consts.BusinessConfigs;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(HomePage.class);

    private final By signInButton = By.className("header-auth__signin");

    private final By topRightCornerUserNameElement = By.className("user-info__name");

    private final By trainingListPageButton = By.xpath("//ul[@class='main-nav__list']//a[contains(@class,'training')]");

    private final By blogPageButton = By.xpath("//ul[@class='main-nav__list']//a[contains(@class,'news')]");

    private final By aboutPageButton = By.className("//ul[@class='main-nav__list']//a[contains(@class,'about')]");

    private final By FAQPageButton = By.xpath("//ul[@class='main-nav__list']//a[contains(@class,'faq')]");


    public SignInPage clickSignInButton() {
        getElement(signInButton).click();
        LOG.info("'Sign in' button clicked");
        return new SignInPage();
    }

    public TrainingListPage clickTrainingListPageButton() {
        getElement(trainingListPageButton).click();
        LOG.info("'Training list' button clicked");
        return new TrainingListPage();
    }

    public HomePage proceedToHomePage() {
        proceedToPage(BusinessConfigs.HOME_PAGE_URL.getUrl());
        LOG.info(String.format("Proceeded to '%s' URL.", BusinessConfigs.HOME_PAGE_URL.getUrl()));
        return this;
    }

    public boolean isUserNameDisplayed(){
        boolean isDisplayed = isDisplayed(topRightCornerUserNameElement);
        LOG.info(String.format("User is logged in: '%s'",isDisplayed));
        return isDisplayed;
    }
    public String getLoggedInUserName(){
        return getElement(topRightCornerUserNameElement).getText();
    }

    public BlogPage clickBlogPageButton() {
        getElement(blogPageButton).click();
        LOG.info("Open 'Blog' page.");
        return new BlogPage();
    }
}