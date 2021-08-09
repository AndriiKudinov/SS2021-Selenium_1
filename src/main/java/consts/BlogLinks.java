package consts;

public enum BlogLinks {
    NEWS("NEWS"), REAL_STORIES("REAL STORIES"), MATERIALS("MATERIALS"),
    HARD_SKILLS("HARD SKILLS"), SOFT_SKILLS("SOFT SKILLS"), EVENTS("EVENTS");

    private final String link;
    BlogLinks(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}