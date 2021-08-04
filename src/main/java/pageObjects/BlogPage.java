package pageObjects;

import consts.BlogLinks;
import consts.Templates;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class BlogPage extends AbstractPage{
    private static final Logger LOG = Logger.getLogger(BlogPage.class);

    public boolean isLinkDisplayed(BlogLinks link){
        String linkName = link.getLink();
        By linkPath = By.xpath(String.format(Templates.BLOG_LINK.getTemplate(), linkName));
        boolean isDisplayed = getElement(linkPath).isDisplayed();
        LOG.info(String.format("Is '%s' link displayed: %s", linkName,isDisplayed));
        return isDisplayed;
    }

    public BlogPage verifyLinkDisplayed(BlogLinks link) {
        softAssert.assertTrue(isLinkDisplayed(link),
                String.format("%s link is not displayed", link.getLink()));
        return this;
    }
}
