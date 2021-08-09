import org.testng.annotations.Test;
import pageObjects.BusinessObjects.HomeBO;

public class BlogPageTest extends BaseTest{
    @Test(description = "Verify all links on ‘Blog’ Page are displayed")
    public void verifyLinksOnBlogPage() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login()
                .clickBlogPageButton()
                .verifyAllLinksAreDisplayed();
    }
}
