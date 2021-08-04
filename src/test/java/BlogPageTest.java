import consts.BlogLinks;
import consts.LoginData;
import org.testng.annotations.Test;
import pageObjects.BusinessObjects.HomeBO;
import pageObjects.HomePage;

public class BlogPageTest extends BaseTest{
    @Test(description = "Verify links on ‘Blog’ Page")
    public void verifyLinksOnBlogPage() {
        new HomeBO()
                .login();
        new HomePage()
                .openBlogPage()
                .verifyLinkDisplayed(BlogLinks.NEWS)
                .verifyLinkDisplayed(BlogLinks.REAL_STORIES)
                .verifyLinkDisplayed(BlogLinks.MATERIALS)
                .verifyLinkDisplayed(BlogLinks.HARD_SKILLS)
                .verifyLinkDisplayed(BlogLinks.SOFT_SKILLS)
                .verifyLinkDisplayed(BlogLinks.EVENTS)
                .softAssertAll();
    }
}
