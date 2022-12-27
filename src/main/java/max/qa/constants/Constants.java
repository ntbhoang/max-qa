package max.qa.constants;

public final class Constants {

    private static final String CURRENT_WORKING_DIR = System.getProperty("user.dir");
    private static final String RESOURCE_PATH = CURRENT_WORKING_DIR + "/src/test/resources";
    private static final String CONFIG_FILE_PATH = RESOURCE_PATH + "/config.properties";
    private static int PAGE_LOAD_TIMEOUT_MAX = 20;


    private Constants(){}

    public static int getPageLoadTimeout() {
        return PAGE_LOAD_TIMEOUT_MAX;
    }

    public static String getConfigFilePath(){
        return CONFIG_FILE_PATH;
    }


}
