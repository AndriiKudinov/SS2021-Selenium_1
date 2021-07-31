import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.TrainingListPage;

public class TrainingListTest extends BaseTest{

    @Test(description = "Is all")
    public void verifyIsAll() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("ivanhorintest@gmail.com")
                .clickContinueButton()
                .enterPassword("ivanhorintestPassword")
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
                .enterEmail("ivanhorintest@gmail.com")
                .clickContinueButton()
                .enterPassword("ivanhorintestPassword")
                .clickSignInButton()
                .clickTrainingList()
                .closeAllCheckedLocations()
                .clickSearchInput()
                .clickUkraineSelectButton()
                .checkLvivCheckbox()
                .verifyResultsAreUkraineAndMultiLocationOnly();
    }
}
