package pageObjects.BusinessObjects;

import org.testng.asserts.SoftAssert;

public class AbstractBO {
    protected final SoftAssert softAssert = new SoftAssert();

    public void softAssertAll() {
        softAssert.assertAll();
    }
}
