import consts.Cities;
import consts.ProgrammingLanguages;
import dataProvider.DataProviders;
import org.testng.annotations.Test;
import pageObjects.BusinessObjects.HomeBO;

import java.util.List;

public class TrainingListTest extends BaseTest{

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Skills’")
    public void verifyTrainingsSearchWorksProperlyWithSkills() {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login()
                .clickTrainingListPageButton()
                .clickSearchInput()
                .clickBySkillsButton()
                .clickProgrammingLanguageCheckbox(ProgrammingLanguages.JAVA)
                .verifyLanguageNameIsIncludedInAllItems(ProgrammingLanguages.JAVA.getName())
                .clickProgrammingLanguageCheckbox(ProgrammingLanguages.JAVA)
                .clickProgrammingLanguageCheckbox(ProgrammingLanguages.RUBY)
                .verifyNoTrainingMessageDisplayed();

    }

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Locations’",
            dataProvider = "LocationsData", dataProviderClass = DataProviders.class)
    public void verifySearchWorksWithLocations(Cities city, List<String> locations) {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .login()
                .clickTrainingListPageButton()
                .closeAllCheckedLocations()
                .clickSearchInput()
                .clickUkraineSelectButton()
                .clickCityCheckbox(city)
                .verifyOnlySelectedLocationsContainedInResults(locations);
    }
}
