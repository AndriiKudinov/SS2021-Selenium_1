package pageObjects.BusinessObjects;

import consts.BlogLinks;
import org.testng.Assert;
import pageObjects.BlogPage;

import java.util.stream.Stream;

public class BlogBO extends AbstractBO{
    private final BlogPage blogPage;

    public BlogBO() {
        blogPage = new BlogPage();
    }

    public BlogBO verifyLinkIsDisplayed(BlogLinks link) {
        Assert.assertTrue(blogPage.isLinkDisplayed(link),
                String.format("'%s' link is not displayed", link.getLink()));
        return this;
    }

    public BlogBO verifyAllLinksAreDisplayed() {
        Stream.of(BlogLinks.values()).forEach(this::verifyLinkIsDisplayed);
        return this;
    }
}
