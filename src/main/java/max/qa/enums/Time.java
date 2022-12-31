package max.qa.enums;

public enum Time {

    PAGE_LOAD_TIME_OUT(25),
    IMPLICIT_WAIT_TIMEOUT(20),
    EXPLICIT_WAIT_TIMEOUT(20);

    private final int value;

    Time(final int newValue) {
        value = newValue;
    }

    public int getValue(){ return value; }
}
