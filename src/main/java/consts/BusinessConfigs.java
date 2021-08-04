package consts;

import utils.ExcelUtils;

public enum BusinessConfigs {
    BASE_URL(ExcelUtils.getStringValue("BusinessConfigs", 0)),
    HOME_PAGE_URL(BASE_URL.url + ExcelUtils.getStringValue("BusinessConfigs", 1)),
    TRAINING_LIST_PAGE_URL(BASE_URL.url + ExcelUtils.getStringValue("BusinessConfigs", 2));

    private final String url;
    BusinessConfigs(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
