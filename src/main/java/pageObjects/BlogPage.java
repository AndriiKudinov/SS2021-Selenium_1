package pageObjects;

import consts.BlogLinks;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BlogPage extends AbstractPage{
    private static final Logger LOG = Logger.getLogger(BlogPage.class);
    private final String blogLinkTemplate = "//span[@class='ng-binding' and contains(text(), '%s')]";


    public boolean isLinkDisplayed(BlogLinks link){
        WebElement element = getElement(By.xpath(String.format(blogLinkTemplate, link.getLink())));
        boolean isDisplayed = element.isDisplayed();
        LOG.info(String.format("Is '%s' link displayed: %s", link.getLink(), isDisplayed));
        return isDisplayed;
    }

}
