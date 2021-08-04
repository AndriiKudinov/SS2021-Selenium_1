package dataProvider;

import consts.LoginData;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "LoginData")
    public static Object[][] getLoginData() {
        return new String[][]{
                {LoginData.CHAR1_EMAIL.getValue()},
                {LoginData.CHAR2_EMAIL.getValue()},
                {LoginData.CHAR63_EMAIL.getValue()},
                {LoginData.CHAR64_EMAIL.getValue()},
        };
    }
}
