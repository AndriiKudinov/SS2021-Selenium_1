package consts;

import utils.ExcelUtils;

public enum LoginData {

    EMAIL(ExcelUtils.getStringValue("LoginConfigs", 0)),
    PASSWORD(ExcelUtils.getStringValue("LoginConfigs", 1)),
    INVALID_EMAIL(ExcelUtils.getStringValue("LoginConfigs", 2)),
    CHAR1_EMAIL(ExcelUtils.getStringValue("LoginConfigs", 3)),
    CHAR2_EMAIL(ExcelUtils.getStringValue("LoginConfigs", 4)),
    CHAR63_EMAIL(ExcelUtils.getStringValue("LoginConfigs", 5)),
    CHAR64_EMAIL(ExcelUtils.getStringValue("LoginConfigs", 6)),
    INCORRECT_PASSWORD(ExcelUtils.getStringValue("LoginConfigs", 7));

    private final String value;
    LoginData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
