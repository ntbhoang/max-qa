package max.qa.utils;

import max.qa.enums.Configuration;
import max.qa.enums.ReportPath;

public final class CommonActions {

    private CommonActions(){}

    public static String getReportPath(){
        String overrideReport = ReadPropertyFile.get(Configuration.OVERRIDE_REPORT);
        String reportPath = "";
        if(overrideReport.equalsIgnoreCase("yes"))
            reportPath = "extent-reports/"  + java.time.LocalDateTime.now() + "-index.html";
        else
            reportPath = ReportPath.EXTENT_PATH.getValue();
        return reportPath;
    }
}
