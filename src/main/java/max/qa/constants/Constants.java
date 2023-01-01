package max.qa.constants;

public final class Constants {

    private static final String CURRENT_WORKING_DIR = System.getProperty("user.dir");
    private static final String RESOURCE_PATH = CURRENT_WORKING_DIR + "/src/test/resources";
    private static final String CONFIG_FILE_PATH = RESOURCE_PATH + "/config.properties";
    private static final String SCREEN_SHOT_DIR_PATH = "/src/test/screenshots";
    private static final String FULL_SCREEN_FILE_PATH = CURRENT_WORKING_DIR + SCREEN_SHOT_DIR_PATH + "/screenshot.png";
    private static final String ELEMENT_SCREENSHOT_PATH = CURRENT_WORKING_DIR + SCREEN_SHOT_DIR_PATH
            + "/element-screenshot.png";


    private Constants(){}

    public static String getConfigFilePath(){
        return CONFIG_FILE_PATH;
    }

    public static String getFullScreenFilePath(){
        return FULL_SCREEN_FILE_PATH;
    }

    public static String getElementScreenshotPath(){
        return ELEMENT_SCREENSHOT_PATH;
    }




}
