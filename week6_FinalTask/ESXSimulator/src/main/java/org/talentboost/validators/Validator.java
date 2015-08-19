package org.talentboost.validators;

import java.util.regex.Pattern;

public abstract class Validator {
    
    protected abstract String getPattern(); 

    public boolean validate(String inputString) {
        String stringToValidate = inputString;

        boolean matches = Pattern.matches(getPattern(), stringToValidate);

        return matches;
    }
    

    
   

}
