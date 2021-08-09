package pageObjects;

import consts.BusinessConfigs;
import consts.Cities;
import consts.ProgrammingLanguages;
import driver.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.List;

public class TrainingListPage extends AbstractPage{
    private static final Logger LOG = Logger.getLogger(TrainingListPage.class);
    private final By searchInput = By.xpath("//input[@name='training-filter-input']");
    private final By bySkillsButton = By.xpath("//div[@class='drop-down-choose__header']//div[contains(text(), 'By skills')]");
    private final By trainingImg = By.xpath("//div[@class='training-list__container training-list__desktop']//img[@class='training-icon']");
    private final By noTrainingsMessage = By.xpath("//div[@class='training-list__subscribe-text']//span[contains(text(), 'No training are available.')]");
    private final By ukraineLocationSelectButton = By.xpath("//div[contains(@class, 'location__not-active-label city-name ng-binding') and contains(text(), 'Ukraine')]");
    private final By locationLabels = By.xpath("//div[@class='training-list__container training-list__desktop']//*[contains(@class, 'training-item__location--text')]");
    private final By closeCheckedLocationsButton = By.xpath("//span[@class='filter-field__input-item-close-icon filter-field__input-item-close-icon--common']");
    private final String skillCheckboxTemplate= "//ul[@class='location__cities-list-cities location__cities-list-skills']//label[normalize-space()='%s']";
    private final String cityCheckboxTemplate = "//ul[@class='location__cities-list-cities ng-scope']//label[normalize-space()='%s']";

    public TrainingListPage proceedToTrainingListPage() {
        proceedToPage(BusinessConfigs.TRAINING_LIST_PAGE_URL.getUrl());
        LOG.info(String.format("Proceeded to '%s' URL.", BusinessConfigs.TRAINING_LIST_PAGE_URL.getUrl()));
        return this;
    }

    public TrainingListPage clickSearchInput() {
        getElement(searchInput).click();
        LOG.info("'Search input' is clicked");
        return this;
    }

    public TrainingListPage clickBySkillsButton() {
        getElement(bySkillsButton).click();
        LOG.info("'By skills' button is clicked");
        return this;
    }

    public TrainingListPage clickProgrammingLanguageCheckbox(ProgrammingLanguages programmingLanguage) {
        By languageCheckbox = By.xpath(String.format(skillCheckboxTemplate, programmingLanguage.getName()));
        getElement(languageCheckbox).click();
        LOG.info(String.format("'%s' checkbox is clicked", programmingLanguage));
        return this;
    }

    public boolean isLanguageNameIncludedInAllItems(String language) {
        List<WebElement> elements = getElements(trainingImg);
        boolean isAll;
        if(!elements.isEmpty()) {
            isAll = elements
                    .stream()
                    .allMatch((x) -> x.getAttribute("src").toLowerCase().contains(language.toLowerCase()));
            LOG.info(String.format("Are all items %s: %s", language, isAll));
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

    public TrainingListPage clickUkraineSelectButton() {
        getElement(ukraineLocationSelectButton).click();
        LOG.info("'Ukraine' button is clicked");
        return this;
    }

    public TrainingListPage clickCityCheckbox(Cities city) {
        String cityName = city.getName();
        By cityCheckbox = By.xpath(String.format(cityCheckboxTemplate, cityName));
        getElement(cityCheckbox).click();
        LOG.info(String.format("'%s' checkbox is clicked", cityName));
        return this;
    }

    public TrainingListPage closeAllCheckedLocations() {
        WebElement closeElement = getElement(closeCheckedLocationsButton);
        closeElement.click();
        LOG.info("All checked locations are closed");
        return this;
    }

    public boolean areLocationsIncludedInAllItems(List<String> locations) {
        if(locations.isEmpty()) {
            LOG.info("There are no locations to compare!");
            return false;
        }
        List<WebElement> elements = getElements(locationLabels);
        boolean result;
        if(!elements.isEmpty()) {
            result = elements
                        .stream()
                        .allMatch(element -> locations
                                .stream()
                                .anyMatch(element.getText()::equalsIgnoreCase));
            LOG.info(String.format("Are only %s locations contained : %s", locations, result));
            return result;
        } else {
            LOG.info("There is no elements at all");
            return true;
        }
    }
}
