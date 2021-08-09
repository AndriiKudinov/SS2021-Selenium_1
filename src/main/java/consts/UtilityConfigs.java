package consts;

import utils.ExcelUtils;
import utils.PropertyUtils;

public enum UtilityConfigs {
    IMPLICITLY_WAIT_VALUE(PropertyUtils.getNumericProperty("IMPLICITLY_WAIT_VALUE"));

    private final int value;
    UtilityConfigs(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
