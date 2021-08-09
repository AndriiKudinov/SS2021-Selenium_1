package dataProvider;

import consts.Cities;
import consts.Locations;
import consts.LoginData;
import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.Collections;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public static Object[][] getLoginData() {
        return new String[][]{
                {LoginData.CHAR1_EMAIL.getValue()},
                {LoginData.CHAR2_EMAIL.getValue()},
                {LoginData.CHAR63_EMAIL.getValue()},
                {LoginData.CHAR64_EMAIL.getValue()},
        };
    }

    @DataProvider(name = "LocationsData")
    public static Object[][] getLocationsData() {
        return new Object[][]{
                {Cities.LVIV, Arrays.asList(Locations.UKRAINE.getName(), Locations.MULTI_LOCATION.getName())}
        };
    }

}
