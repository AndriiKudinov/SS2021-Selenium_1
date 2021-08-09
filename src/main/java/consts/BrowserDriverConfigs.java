package consts;

import utils.PropertyUtils;

public enum BrowserDriverConfigs {
    CHROME(PropertyUtils.getStringProperty("CHROME_NAME"), PropertyUtils.getStringProperty("CHROME_DRIVER_LOCATION")),
    FIREFOX(PropertyUtils.getStringProperty("FIREFOX_NAME"), PropertyUtils.getStringProperty("FIREFOX_DRIVER_LOCATION")),
    EDGE(PropertyUtils.getStringProperty("EDGE_NAME"), PropertyUtils.getStringProperty("EDGE_DRIVER_LOCATION"));

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
