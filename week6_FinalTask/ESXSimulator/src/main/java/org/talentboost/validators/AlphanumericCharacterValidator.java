package org.talentboost.validators;

public class AlphanumericCharacterValidator extends Validator{
    private static final String PATTERN = "^[a-zA-Z0-9]+";
    private static AlphanumericCharacterValidator instance = null;
    
    private AlphanumericCharacterValidator(){};
    
    public static AlphanumericCharacterValidator getInstance(){
        if(instance == null) {
            instance = new AlphanumericCharacterValidator();
         }
         return instance;
    }
    
    @Override
    protected String getPattern() {
        return PATTERN;
    }
    
}
