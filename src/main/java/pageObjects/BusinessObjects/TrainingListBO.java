package pageObjects.BusinessObjects;

import consts.Cities;
import consts.ProgrammingLanguages;
import org.testng.Assert;
import pageObjects.TrainingListPage;

import java.util.Arrays;
import java.util.List;

public class TrainingListBO extends AbstractBO {
    private final TrainingListPage trainingListPage;

    public TrainingListBO() {
        trainingListPage = new TrainingListPage();
    }

    public TrainingListBO clickSearchInput() {
        trainingListPage.clickSearchInput();
        return this;
    }

    public TrainingListBO clickBySkillsButton() {
        trainingListPage.clickBySkillsButton();
        return this;
    }

    public TrainingListBO clickProgrammingLanguageCheckbox(ProgrammingLanguages programmingLanguage) {
        trainingListPage.clickProgrammingLanguageCheckbox(programmingLanguage);
        return this;
    }

    public TrainingListBO clickUkraineSelectButton() {
        trainingListPage.clickUkraineSelectButton();
        return this;
    }

    public TrainingListBO clickCityCheckbox(Cities city) {
        trainingListPage.clickCityCheckbox(city);
        return this;
    }

    public TrainingListBO closeAllCheckedLocations() {
        trainingListPage.closeAllCheckedLocations();
        return this;
    }

    public TrainingListBO verifyLanguageNameIsIncludedInAllItems(String language) {
        Assert.assertTrue(trainingListPage.isLanguageNameIncludedInAllItems(language),
                String.format("Not all items are %s", language));
        return this;
    }

    public TrainingListBO verifyNoTrainingMessageDisplayed() {
        Assert.assertTrue(trainingListPage.isNoTrainingMessageDisplayed(),
                "'No trainings available' is not displayed");
        return this;
    }

    public TrainingListBO verifyOnlySelectedLocationsContainedInResults(List<String> locations) {
        Assert.assertTrue(trainingListPage.areLocationsIncludedInAllItems(locations),
                String.format("There is something other than %s in the results.", locations));
        return this;
    }
}
