package consts;

import org.testng.annotations.DataProvider;
import utils.ExcelUtils;

public class Constants {

    //Constants should be stored in Enums or files
    public static class DriverConfigs{
        public static final String CHROME_NAME = ExcelUtils.getStringValue("DriverConfigs", 0);
        public static final String FIREFOX_NAME = ExcelUtils.getStringValue("DriverConfigs", 1);
        public static final String EDGE_NAME = ExcelUtils.getStringValue("DriverConfigs", 2);
        public static final String CHROME_DRIVER_LOCATION = ExcelUtils.getStringValue("DriverConfigs", 3);
        public static final String FIREFOX_DRIVER_LOCATION = ExcelUtils.getStringValue("DriverConfigs", 4);
        public static final String EDGE_DRIVER_LOCATION = ExcelUtils.getStringValue("DriverConfigs", 5);
        public static final int IMPLICITLY_WAIT_VALUE = ExcelUtils.getNumericValue("DriverConfigs", 6);
    }

    public static class BusinessConfigs {
        public static final String BASE_URL = ExcelUtils.getStringValue("BusinessConfigs", 0);
        public static final String HOME_PAGE_URL = BASE_URL + ExcelUtils.getStringValue("BusinessConfigs", 1);
        public static final String TRAINING_LIST_PAGE_URL = BASE_URL + ExcelUtils.getStringValue("BusinessConfigs", 2);
    }

    public static class LogConfigs {
        public static final String EMAIL = ExcelUtils.getStringValue("LogConfigs", 0);
        public static final String PASSWORD = ExcelUtils.getStringValue("LogConfigs", 1);
        public static final String INVALID_EMAIL = ExcelUtils.getStringValue("LogConfigs", 2);
        public static final String CHAR1_EMAIL = ExcelUtils.getStringValue("LogConfigs", 3);
        public static final String CHAR2_EMAIL = ExcelUtils.getStringValue("LogConfigs", 4);
        public static final String CHAR63_EMAIL = ExcelUtils.getStringValue("LogConfigs", 5);
        public static final String CHAR64_EMAIL = ExcelUtils.getStringValue("LogConfigs", 6);
    }

}