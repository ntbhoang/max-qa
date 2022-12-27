package max.qa.enums;

public enum Time {

    PAGE_LOAD_TIME_OUT(15),
    IMPLICIT_WAIT_TIMEOUT(10),
    EXPLICIT_WAIT_TIMEOUT(15);

    private final int value;

    Time(final int newValue) {
        value = newValue;
    }

    public int getValue(){ return value; }
}
