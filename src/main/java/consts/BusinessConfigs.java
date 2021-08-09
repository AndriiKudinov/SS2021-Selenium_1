package consts;

import utils.PropertyUtils;

public enum BusinessConfigs {
    BASE_URL(PropertyUtils.getStringProperty("BASE_URL")),
    HOME_PAGE_URL(BASE_URL.url + PropertyUtils.getStringProperty("HOME_PAGE_URL")),
    TRAINING_LIST_PAGE_URL(BASE_URL.url + PropertyUtils.getStringProperty("TRAINING_LIST_PAGE_URL"));

    private final String url;
    BusinessConfigs(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
