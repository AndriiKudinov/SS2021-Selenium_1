package consts;

import utils.ExcelUtils;

public enum BrowserDriverConfigs {

    CHROME(ExcelUtils.getStringValue("DriverConfigs", 0), ExcelUtils.getStringValue("DriverConfigs", 3)),
    FIREFOX(ExcelUtils.getStringValue("DriverConfigs", 1), ExcelUtils.getStringValue("DriverConfigs", 4)),
    EDGE(ExcelUtils.getStringValue("DriverConfigs", 2), ExcelUtils.getStringValue("DriverConfigs", 5));

    private final String name;
    private final String driverLocation;
    BrowserDriverConfigs(String name, String driverLocation) {
        this.name = name;
        this.driverLocation = driverLocation;
    }

    public String getName() {
        return name;
    }

    public String getDriverLocation() {
        return driverLocation;
    }
}
