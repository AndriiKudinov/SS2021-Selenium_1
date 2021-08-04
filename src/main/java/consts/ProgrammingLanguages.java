package consts;

public enum ProgrammingLanguages {
    JAVA("Java"), RUBY("Ruby");

    private final String value;
    ProgrammingLanguages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
