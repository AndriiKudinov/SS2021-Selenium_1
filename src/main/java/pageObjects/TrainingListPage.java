package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static consts.Constants.BusinessConfigs.TRAINING_LIST_PAGE_URL;

public class TrainingListPage extends AbstractPage{
    private static final Logger LOG = Logger.getLogger(HomePage.class);
    private final By searchInput = By.xpath("//input[@name='training-filter-input']");
    private final By bySkillsButton = By.xpath("//div[@class='drop-down-choose__header']//div[contains(text(), 'By skills')]");
    private final By javaSkillCheckbox = By.xpath("//ul[@class='location__cities-list-cities location__cities-list-skills']//label[normalize-space()='Java']");
    private final By rubySkillCheckbox = By.xpath("//ul[@class='location__cities-list-cities location__cities-list-skills']//label[normalize-space()='Ruby']");
    private final By trainingImg = By.xpath("//div[@class='training-list__container training-list__desktop']//img[@class='training-icon']");
    private final By noTrainingsMessage = By.xpath("//div[@class='training-list__subscribe-text']//span[contains(text(), 'No training are available.')]");
    private final By ukraineLocationSelectButton = By.xpath("//div[contains(@class, 'location__not-active-label city-name ng-binding') and contains(text(), 'Ukraine')]");
    private final By lvivCheckbox = By.xpath("//ul[@class='location__cities-list-cities ng-scope']//label[normalize-space()='Lviv']");
    private final By locationLabels = By.xpath("//div[@class='training-list__container training-list__desktop']//*[contains(@class, 'training-item__location--text')]");
    private final By inputItemCloseIcon = By.xpath("//span[@class='filter-field__input-item-close-icon']");

    public TrainingListPage proceedToTrainingListPage() {
        proceedToPage(TRAINING_LIST_PAGE_URL);
        LOG.info(String.format("Proceeded to '%s' URL.", TRAINING_LIST_PAGE_URL));
        return this;
    }

    public TrainingListPage clickSearchInput() {
        getElement(searchInput).click();
        LOG.info("'Search input' clicked");
        return this;
    }

    public TrainingListPage clickBySkillsButton() {
        getElement(bySkillsButton).click();
        LOG.info("'By skills' button clicked");
        return this;
    }

    public TrainingListPage clickJavaCheckbox() {
        getElement(javaSkillCheckbox).click();
        LOG.info("'Java checkbox' clicked");
        return this;
    }

    public boolean isAllItemsJava() {
        List<WebElement> elements = getElements(trainingImg);
        boolean isAll;
        if(!elements.isEmpty()) {
            isAll = elements
                    .stream()
                    .allMatch((x) -> x.getAttribute("src").toLowerCase().contains("java"));
            LOG.info(String.format("Is all items Java: %s", isAll));
            return isAll;
        } else {
            LOG.info("There is no elements at all");
            return true;
        }
    }

    public TrainingListPage checkRubyCheckbox() {
        getElement(rubySkillCheckbox).click();
        LOG.info("'Ruby checkbox' checked");
        return this;
    }

    public boolean isNoTrainingMessageDisplayed() {
        boolean isDisplayed = isDisplayed(noTrainingsMessage);
        LOG.info(String.format("Is 'No trainings available' displayed: %s", isDisplayed));
        return isDisplayed;
    }

    public void verifyNoTrainingMessageDisplayed() {
        Assert.assertTrue(isNoTrainingMessageDisplayed(),
                "'No trainings available' is not displayed");
    }

    public void verifyAllItemsJava() {
        Assert.assertTrue(isAllItemsJava(),
                "Not all items are Java");
    }

    public TrainingListPage clickUkraineSelectButton() {
        getElement(ukraineLocationSelectButton).click();
        LOG.info("'Ukraine' button clicked");
        return this;
    }

    public TrainingListPage checkLvivCheckbox() {
        getElement(lvivCheckbox).click();
        LOG.info("'Lviv checkbox' checked");
        return this;
    }

    public TrainingListPage closeAllCheckedLocations() {
        List<WebElement> elements = getElements(inputItemCloseIcon);
        if(!elements.isEmpty()) {
            elements.forEach(WebElement::click);
            LOG.info("All checked locations closed");
        }
        return this;
    }

    public boolean isUkraineAndMultiLocationOnly() {
        List<WebElement> elements = getElements(locationLabels);
        boolean result;
        if(!elements.isEmpty()) {
            result = elements
                        .stream()
                        .allMatch(x -> x.getText().contains("Ukraine") || x.getText().contains("Multi-location"));
            LOG.info(String.format("Are there only Ukraine and Multi-location: %s", result));
            return result;
        } else {
            LOG.info("There is no elements at all");
            return true;
        }
    }

    public void verifyResultsAreUkraineAndMultiLocationOnly() {
        Assert.assertTrue(isUkraineAndMultiLocationOnly(),
                "There is something other than Ukraine and Multi-location in the results.");
    }
}
