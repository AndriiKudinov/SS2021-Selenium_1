package consts;

import utils.ExcelUtils;

public enum UtilityConfigs {
    IMPLICITLY_WAIT_VALUE(ExcelUtils.getNumericValue("DriverConfigs", 6));

    private final int value;
    UtilityConfigs(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
