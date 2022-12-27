package max.qa.enums;


import java.util.EnumMap;

public class Credential{

    public enum SLCredentials{
        STANDARD_USER,
        LOCKED_OUT_USER,
        PROBLEM_USER,
        PERFORMANCE_GLITCH_USER,
        PASSWORD,
    }

    static {

    }

    private static EnumMap<SLCredentials, String> setCredentials(){
        EnumMap<SLCredentials, String> credentials
                = new EnumMap<>(SLCredentials.class);
        credentials.put(SLCredentials.STANDARD_USER, "standard_user");
        credentials.put(SLCredentials.PROBLEM_USER, "problem_user");
        credentials.put(SLCredentials.LOCKED_OUT_USER, "locked_out_user");
        credentials.put(SLCredentials.PERFORMANCE_GLITCH_USER, "performance_glitch_user");
        credentials.put(SLCredentials.PASSWORD, "secret_sauce");

        return credentials;
    }

    public static String getCredential(SLCredentials key){
        EnumMap<Credential.SLCredentials, String> credentials = Credential.setCredentials();
        return credentials.get(key);
    }
}