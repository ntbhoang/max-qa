package max.qa.enums;

public enum ReportPath {

    EXTENT_PATH("extent-reports/extent-report.html");

    private final String value;

    public String getValue(){ return value; }

    ReportPath(final String s) {
        value = s;
    }
}
