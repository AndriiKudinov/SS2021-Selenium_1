import org.testng.annotations.Test;
import pageObjects.HomePage;

public class BlogPageTest extends BaseTest{
    @Test(description = "Verify links on ‘Blog’ Page")
    public void verifyLinksOnBlogPage() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("ivanhorintest@gmail.com")
                .clickContinueButton()
                .enterPassword("ivanhorintestPassword")
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
