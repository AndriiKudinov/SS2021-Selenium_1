import consts.Constants;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.TrainingListPage;

public class TrainingListTest extends BaseTest{

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Skills’")
    public void verifyTrainingsSearchWorksProperlyWithSkills() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(Constants.LogConfigs.EMAIL)
                .clickContinueButton()
                .enterPassword(Constants.LogConfigs.PASSWORD)
                .clickSignInButton()
                .clickTrainingList()
                .clickSearchInput()
                .clickBySkillsButton()
                .clickJavaCheckbox()
                .verifyAllItemsJava();
        new TrainingListPage()
                .clickJavaCheckbox()
                .checkRubyCheckbox()
                .verifyNoTrainingMessageDisplayed();

    }

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Locations’")
    public void verifySearchWorksWithLocations() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(Constants.LogConfigs.EMAIL)
                .clickContinueButton()
                .enterPassword(Constants.LogConfigs.PASSWORD)
                .clickSignInButton()
                .clickTrainingList()
                .closeAllCheckedLocations()
                .clickSearchInput()
                .clickUkraineSelectButton()
                .checkLvivCheckbox()
                .verifyResultsAreUkraineAndMultiLocationOnly();
    }
}
