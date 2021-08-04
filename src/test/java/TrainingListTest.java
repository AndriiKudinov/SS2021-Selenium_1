import consts.Cities;
import consts.LoginData;
import consts.ProgrammingLanguages;
import org.testng.annotations.Test;
import pageObjects.BusinessObjects.HomeBO;
import pageObjects.HomePage;
import pageObjects.TrainingListPage;

public class TrainingListTest extends BaseTest{

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Skills’")
    public void verifyTrainingsSearchWorksProperlyWithSkills() {
        new HomeBO()
                .login();
        new HomePage()
                .clickTrainingList()
                .clickSearchInput()
                .clickBySkillsButton()
                .clickProgrammingLanguageCheckbox(ProgrammingLanguages.JAVA)
                .verifyAllItemsJava()
                .clickProgrammingLanguageCheckbox(ProgrammingLanguages.JAVA)
                .clickProgrammingLanguageCheckbox(ProgrammingLanguages.RUBY)
                .verifyNoTrainingMessageDisplayed();

    }

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Locations’")
    public void verifySearchWorksWithLocations() {
        new HomeBO()
                .login();
        new HomePage()
                .clickTrainingList()
                .closeAllCheckedLocations()
                .clickSearchInput()
                .clickUkraineSelectButton()
                .clickCityCheckbox(Cities.LVIV)
                .verifyResultsAreUkraineAndMultiLocationOnly();
    }
}
