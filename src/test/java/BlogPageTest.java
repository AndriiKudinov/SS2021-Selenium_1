import consts.Constants;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class BlogPageTest extends BaseTest{
    @Test(description = "Verify links on ‘Blog’ Page")
    public void verifyLinksOnBlogPage() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(Constants.LogConfigs.EMAIL)
                .clickContinueButton()
                .enterPassword(Constants.LogConfigs.PASSWORD)
                .clickSignInButton()
                .openBlogPage()
                .verifyNewsLinkDisplayed()
                .verifyRealStoriesLinkDisplayed()
                .verifyMaterialsLinkDisplayed()
                .verifyHardSkillsLinkDisplayed()
                .verifySoftSkillsLinkDisplayed()
                .verifyEventsLinkDisplayed()
                .softAssertAll();
    }
}
