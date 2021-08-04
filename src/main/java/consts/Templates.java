package consts;

public enum Templates {
    SKILL_CHECKBOX("//ul[@class='location__cities-list-cities location__cities-list-skills']//label[normalize-space()='%s']"),
    CITY_CHECKBOX("//ul[@class='location__cities-list-cities ng-scope']//label[normalize-space()='%s']"),
    BLOG_LINK("//span[@class='ng-binding' and contains(text(), '%s')]");

    private final String template;
    Templates(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }
}
