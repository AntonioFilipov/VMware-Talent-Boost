package org.talentboost.utils;
import java.util.Locale;
import java.util.ResourceBundle;

public class ErrorBundle {
    private static ResourceBundle bundle = ResourceBundle.getBundle("org.talentboost.utils.errorMessages",Locale.US);

    public static String getErrorMessage(String message, String type){
        String errMesage = bundle.getString(message);
        return String.format(errMesage, type);
    }
}
