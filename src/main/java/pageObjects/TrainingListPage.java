package pageObjects;

import consts.BusinessConfigs;
import consts.Cities;
import consts.ProgrammingLanguages;
import consts.Templates;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class TrainingListPage extends AbstractPage{
    private static final Logger LOG = Logger.getLogger(HomePage.class);
    private final By searchInput = By.xpath("//input[@name='training-filter-input']");
    private final By bySkillsButton = By.xpath("//div[@class='drop-down-choose__header']//div[contains(text(), 'By skills')]");
    private final By trainingImg = By.xpath("//div[@class='training-list__container training-list__desktop']//img[@class='training-icon']");
    private final By noTrainingsMessage = By.xpath("//div[@class='training-list__subscribe-text']//span[contains(text(), 'No training are available.')]");
    private final By ukraineLocationSelectButton = By.xpath("//div[contains(@class, 'location__not-active-label city-name ng-binding') and contains(text(), 'Ukraine')]");
    private final By locationLabels = By.xpath("//div[@class='training-list__container training-list__desktop']//*[contains(@class, 'training-item__location--text')]");
    private final By inputItemCloseIcon = By.xpath("//span[@class='filter-field__input-item-close-icon']");

    public TrainingListPage proceedToTrainingListPage() {
        proceedToPage(BusinessConfigs.TRAINING_LIST_PAGE_URL.getUrl());
        LOG.info(String.format("Proceeded to '%s' URL.", BusinessConfigs.TRAINING_LIST_PAGE_URL.getUrl()));
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

    public TrainingListPage clickProgrammingLanguageCheckbox(ProgrammingLanguages programmingLanguage) {
        String language = programmingLanguage.getValue();
        By languageCheckbox = By.xpath(String.format(Templates.SKILL_CHECKBOX.getTemplate(), language));
        getElement(languageCheckbox).click();
        LOG.info(String.format("'%s' checkbox is clicked", language));
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

    public boolean isNoTrainingMessageDisplayed() {
        boolean isDisplayed = isDisplayed(noTrainingsMessage);
        LOG.info(String.format("Is 'No trainings available' displayed: %s", isDisplayed));
        return isDisplayed;
    }

    public TrainingListPage verifyNoTrainingMessageDisplayed() {
        Assert.assertTrue(isNoTrainingMessageDisplayed(),
                "'No trainings available' is not displayed");
        return this;
    }

    public TrainingListPage verifyAllItemsJava() {
        Assert.assertTrue(isAllItemsJava(),
                "Not all items are Java");
        return this;
    }

    public TrainingListPage clickUkraineSelectButton() {
        getElement(ukraineLocationSelectButton).click();
        LOG.info("'Ukraine' button clicked");
        return this;
    }

    public TrainingListPage clickCityCheckbox(Cities city) {
        String cityName = city.getName();
        By cityCheckbox = By.xpath(String.format(Templates.CITY_CHECKBOX.getTemplate(), cityName));
        getElement(cityCheckbox).click();
        LOG.info(String.format("'%s' checkbox is clicked", cityName));
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

    public TrainingListPage verifyResultsAreUkraineAndMultiLocationOnly() {
        Assert.assertTrue(isUkraineAndMultiLocationOnly(),
                "There is something other than Ukraine and Multi-location in the results.");
        return this;
    }
}
