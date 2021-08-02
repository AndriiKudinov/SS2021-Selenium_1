package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class BlogPage extends AbstractPage{
    private static final Logger LOG = Logger.getLogger(BlogPage.class);

    private final By newsLink = By.xpath("//span[@class='ng-binding' and contains(text(), 'NEWS')]");
    private final By realStoriesLink = By.xpath("//span[@class='ng-binding' and contains(text(), 'REAL STORIES')]");
    private final By materialsLink = By.xpath("//span[@class='ng-binding' and contains(text(), 'MATERIALS')]");
    private final By hardSkillsLink = By.xpath("//span[@class='ng-binding' and contains(text(), 'HARD SKILLS')]");
    private final By softSkillsLink = By.xpath("//span[@class='ng-binding' and contains(text(), 'SOFT SKILLS')]");
    private final By eventsLink = By.xpath("//span[@class='ng-binding' and contains(text(), 'EVENTS')]");

    public boolean isNewsLinkDisplayed(){
        boolean isDisplayed = getElement(newsLink).isDisplayed();
        LOG.info(String.format("Is 'news' link displayed: %s", isDisplayed));
        return isDisplayed;
    }

    public BlogPage verifyNewsLinkDisplayed() {
        softAssert.assertTrue(isNewsLinkDisplayed(),
                "News link is not displayed");
        return this;
    }

    public boolean isMaterialsLinkDisplayed(){
        boolean isDisplayed = getElement(materialsLink).isDisplayed();
        LOG.info(String.format("Is 'materials' link displayed: %s", isDisplayed));
        return isDisplayed;
    }

    public BlogPage verifyMaterialsLinkDisplayed() {
        softAssert.assertTrue(isMaterialsLinkDisplayed(),
                "Materials link is not displayed");
        return this;
    }

    public boolean isRealStoriesLinkDisplayed(){
        boolean isDisplayed = getElement(realStoriesLink).isDisplayed();
        LOG.info(String.format("Is 'real stories' link displayed: %s", isDisplayed));
        return isDisplayed;
    }

    public BlogPage verifyRealStoriesLinkDisplayed() {
        softAssert.assertTrue(isRealStoriesLinkDisplayed(),
                "Real stories link is not displayed");
        return this;
    }

    public boolean isHardSkillsLinkDisplayed(){
        boolean isDisplayed = getElement(hardSkillsLink).isDisplayed();
        LOG.info(String.format("Is 'Hard Skills' link displayed: %s", isDisplayed));
        return isDisplayed;
    }

    public BlogPage verifyHardSkillsLinkDisplayed() {
        softAssert.assertTrue(isHardSkillsLinkDisplayed(),
                "Hard skills link is not displayed");
        return this;
    }

    public boolean isSoftSkillsLinkDisplayed(){
        boolean isDisplayed = getElement(softSkillsLink).isDisplayed();
        LOG.info(String.format("Is 'Soft skills' link displayed: %s", isDisplayed));
        return isDisplayed;
    }

    public BlogPage verifySoftSkillsLinkDisplayed() {
        softAssert.assertTrue(isSoftSkillsLinkDisplayed(),
                "Soft skills link is not displayed");
        return this;
    }

    public boolean isEventsLinkDisplayed(){
        boolean isDisplayed = getElement(eventsLink).isDisplayed();
        LOG.info(String.format("Is 'events' link displayed: %s", isDisplayed));
        return isDisplayed;
    }

    public BlogPage verifyEventsLinkDisplayed() {
        softAssert.assertTrue(isEventsLinkDisplayed(),
                "Real stories link is not displayed");
        return this;
    }
}
