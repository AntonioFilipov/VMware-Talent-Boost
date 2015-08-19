package org.talentboost.validators;

public class IPv4Validator extends Validator {

    private static final String PATTERN = 
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    private static IPv4Validator instance = null;
    
    private IPv4Validator(){};
    
    public static IPv4Validator getInstance(){
        if(instance == null) {
            instance = new IPv4Validator();
         }
         return instance;
    }
    
    @Override
    protected String getPattern() {
        return PATTERN;
    }
}
